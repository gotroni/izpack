package com.izforge.izpack.installer.provider;

import com.izforge.izpack.data.ResourceManager;
import com.izforge.izpack.installer.base.ConditionCheck;
import com.izforge.izpack.installer.base.LanguageDialog;
import com.izforge.izpack.installer.data.GUIInstallData;
import org.picocontainer.injectors.Provider;

import javax.swing.*;
import java.awt.*;

/**
 * Provider for language dialog
 */
public class LanguageDialogProvider implements Provider {
    private ResourceManager resourceManager;

    public LanguageDialog provide(GUIInstallData installDataGUI, ResourceManager resourceManager, ConditionCheck conditionCheck) throws Exception {
        this.resourceManager = resourceManager;
        return new LanguageDialog(initFrame(), resourceManager, installDataGUI, conditionCheck);
    }

    private JFrame initFrame() {
        // Dummy Frame
        JFrame frame = new JFrame();
        frame.setIconImage(
                resourceManager.getImageIconResource("/img/JFrameIcon.png").getImage()
        );
        Dimension frameSize = frame.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2 - 10);
        return frame;
    }

}