package com.dtp.core.support;

import com.dtp.common.config.DtpProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;

/**
 * DtpBannerPrinter
 *
 * @author 方便面
 * @date 2022/5/2
 */
@Slf4j
public class DtpBannerPrinter implements InitializingBean {


    private final DtpProperties dtpProperties;

    public DtpBannerPrinter(DtpProperties properties) {
        this.dtpProperties = properties;
    }

    private static final String NAME = " :: Dynamic Thread Pool :: ";

    private static final String BANNER = " __  ___  ___     // / ___          ___   / __  ___  ___    \n" +
                                        "  / /   //   ) ) // //\\ \\   ____  //   ) /   / /   //   ) ) \n" +
                                        " / /   //   / / // //  \\ \\       //   / /   / /   //___/ /  \n" +
                                        "/ /   ((___( ( // //    \\ \\     ((___/ /   / /   //         \n";

    @Override
    public void afterPropertiesSet() {
        if (!dtpProperties.isEnabledBanner()) {
            return;
        }

        log.info(AnsiOutput.toString(BANNER, "\n", AnsiColor.GREEN, NAME,
                AnsiColor.DEFAULT, AnsiStyle.FAINT));
    }
}
