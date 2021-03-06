package me.hehaiyang.codegen;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import me.hehaiyang.codegen.config.SettingManager;
import me.hehaiyang.codegen.model.IdeaContext;
import me.hehaiyang.codegen.utils.PsiUtil;
import me.hehaiyang.codegen.windows.DBWindow;
import me.hehaiyang.codegen.windows.SQLWindow;

import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class CodeGenAction extends AnAction {

    public CodeGenAction() {
        super(AllIcons.Icon_small);
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {

        SettingManager settingManager = SettingManager.getInstance();

        IdeaContext ideaContext = new IdeaContext();
        ideaContext.setProject(PsiUtil.getProject(anActionEvent));

//        Locale locale = new Locale("zh", "CN");
        Locale locale = new Locale("en", "US");
//        Locale locale = Locale.getDefault();

        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        JFrame startFrame;
        if(settingManager.getConfigSetting().isDbRadio()){
            startFrame = new DBWindow(ideaContext);
            startFrame.setSize(350, 180);
        }else{
            startFrame = new SQLWindow(ideaContext);
            startFrame.setSize(500, 350);
        }
//        startFrame.setTitle(bundle.getString("aaa"));

        startFrame.setResizable(false);
        startFrame.setAlwaysOnTop(true);
        startFrame.setLocationRelativeTo(null);
        startFrame.setVisible(true);
    }

}
