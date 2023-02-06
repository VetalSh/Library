package library.controller.filters;

import com.github.cage.Cage;
import com.github.cage.GCage;
import library.utils.constants.Pages;
import library.exceptions.ServiceException;
import library.model.entities.User;
import library.utils.Captcha;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static library.utils.constants.ServletAttributes.*;

public class CaptchaGenerator implements Filter {
    private static final Logger logger = LogManager.getLogger(CaptchaGenerator.class);
    private final Cage cage = new GCage();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();

        User currentUser = (User) session.getAttribute(USER);
        if (currentUser != null) { //means user is authenticated
            filterChain.doFilter(servletRequest, servletResponse);
        }

        try {
            Captcha captcha = new Captcha();
            session.setAttribute("captcha", captcha);
            logger.trace("captcha saved to session {}", captcha);
        } catch (ServiceException e) {
            session.setAttribute(SERVICE_ERROR, e);
            session.setAttribute(SERVICE_ERROR_PARAMETERS, e.getMsgParameters());
            servletRequest.getRequestDispatcher(Pages.ERROR).forward(servletRequest, servletResponse);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
