package org.lukedowell.supernat.services;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by ldowell on 12/2/15.
 */
@Service
public class ReportService {

    /** The path of the master election report */
    private static final String REPORT_PATH = "/static/report/rpt_election.jrxml";

    /**
     * @param params
     * @return
     *      A filled JasperReport
     * @throws JRException
     */
    public JasperReport getFilledReport(Map<String, Object> params) throws JRException {
        JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(REPORT_PATH);
        JasperFillManager.fillReport(report, params);
        return report;
    }
}
