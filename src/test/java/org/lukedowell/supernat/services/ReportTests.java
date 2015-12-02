package org.lukedowell.supernat.services;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import org.junit.Before;

/**
 * Created by ldowell on 12/2/15.
 */
public class ReportTests {

    private JasperReport report;

    @Before
    public void setUp() {
        try {

            report = (JasperReport) JRLoader.loadObjectFromFile("/Users/ldowell/Documents/development/SuperNAT/src/main/resources/static/report/electionreport.jasper");

        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
