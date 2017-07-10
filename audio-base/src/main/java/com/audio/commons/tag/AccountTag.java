package com.audio.commons.tag;

import com.audio.cache.CacheConfig;
import com.audio.core.entity.BoxUser;
import com.audio.core.entity.Config;
import com.audio.core.entity.Notice;
import com.audio.core.manager.Manager;
import com.audio.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class AccountTag extends TagSupport
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 9087412695683723992L;

    private HttpServletRequest request = null;

    //uid
    private String uid;

    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            buildPage();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    private void buildPage() throws IOException
    {

        String account="";
        try
        {
            BoxUser users = (BoxUser) Manager.invoke()
                    .userManager(pageContext.getRequest().getServletContext())
                    .loadDate(3, uid);
            account = users.getAccount()+"-"+ users.getT_name();
        }
        catch (Exception e)
        {

        }
        if (StringUtil.isEmpty(account))
        {
            account="No-User";
        }
        JspWriter out = pageContext.getOut();
        out.print(account);
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }
}
