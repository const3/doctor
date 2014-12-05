///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package mx.um.edu.medicina.dao.hibernate;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.util.Date;
//import java.util.List;
//import mx.um.edu.medicina.model.Forecast;
//import org.hibernate.Query;
//import org.hibernate.SessionFactory;
//import org.hibernate.stat.Statistics;
//import org.springframework.stereotype.Repository;
//import weka.classifiers.evaluation.NumericPrediction;
//import weka.classifiers.functions.GaussianProcesses;
//import weka.core.Instances;
//
///**
// *
// * @author develop
// */
//@Repository("forecastDao")
//public class ForecastDaoHibernate extends GenericDaoHibernate<Forecast, Long> {
//
//    public void HabStats() {
//        SessionFactory sessionFactory = getSessionFactory();
//        Statistics stats = sessionFactory.getStatistics();
//        stats.setStatisticsEnabled(true);
//        Long maxtime = stats.getQueryExecutionMaxTime();
//        Forecast forecast = new Forecast();
//        forecast.setFecha(new Date());
//        forecast.setTimeMax(maxtime);
//        save(forecast);
//
//    }
//
//    public void ProcessWeka() {
//         try {
//      // path to the Australian wine data included with the time series forecasting
//      // package
//      String pathToWineData = weka.core.WekaPackageManager.PACKAGES_DIR.toString()
//        + File.separator + "timeseriesForecasting" + File.separator + "sample-data"
//        + File.separator + "wine.arff";
//
//      // load the wine data
//      Instances wine = new Instances(new BufferedReader(new FileReader(pathToWineData)));
//
//      // new forecaster
//      WekaForecaster forecaster = new WekaForecaster();
//
//      // set the targets we want to forecast. This method calls
//      // setFieldsToLag() on the lag maker object for us
//      forecaster.setFieldsToForecast("Fortified,Dry-white");
//
//      // default underlying classifier is SMOreg (SVM) - we'll use
//      // gaussian processes for regression instead
//      forecaster.setBaseForecaster(new GaussianProcesses());
//
//      forecaster.getTSLagMaker().setTimeStampField("Date"); // date time stamp
//      forecaster.getTSLagMaker().setMinLag(1);
//      forecaster.getTSLagMaker().setMaxLag(12); // monthly data
//
//      // add a month of the year indicator field
//      forecaster.getTSLagMaker().setAddMonthOfYear(true);
//
//      // add a quarter of the year indicator field
//      forecaster.getTSLagMaker().setAddQuarterOfYear(true);
//
//      // build the model
//      forecaster.buildForecaster(wine, System.out);
//
//      // prime the forecaster with enough recent historical data
//      // to cover up to the maximum lag. In our case, we could just supply
//      // the 12 most recent historical instances, as this covers our maximum
//      // lag period
//      forecaster.primeForecaster(wine);
//
//      // forecast for 12 units (months) beyond the end of the
//      // training data
//      List<List<NumericPrediction>> forecast = forecaster.forecast(12, System.out);
//
//      // output the predictions. Outer list is over the steps; inner list is over
//      // the targets
//      for (int i = 0; i < 12; i++) {
//        List<NumericPrediction> predsAtStep = forecast.get(i);
//        for (int j = 0; j < 2; j++) {
//          NumericPrediction predForTarget = predsAtStep.get(j);
//          System.out.print("" + predForTarget.predicted() + " ");
//        }
//        System.out.println();
//      }
//
//      // we can continue to use the trained forecaster for further forecasting
//      // by priming with the most recent historical data (as it becomes available).
//      // At some stage it becomes prudent to re-build the model using current
//      // historical data.
//
//    } catch (Exception ex) {
//      ex.printStackTrace();
//    }
//    }
//
//    /**
//     * Constructor that sets the entity to Forecast.class.
//     */
//    public ForecastDaoHibernate() {
//        super(Forecast.class);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @SuppressWarnings("unchecked")
//    public List<Forecast> getForecasts() {
//        Query qry = getSession().createQuery("from Forecast p ");
//        return qry.list();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    public Forecast saveForecast(Forecast forecast) {
//        if (log.isDebugEnabled()) {
//            log.debug("forecast's id: " + forecast.getId());
//        }
//        getSession().saveOrUpdate(forecast);
//        // necessary to throw a DataIntegrityViolation and catch it in ForecastManager
//        getSession().flush();
//        return forecast;
//    }
//
//    /**
//     * Overridden simply to call the saveForecast method. This is happening
//     * because saveForecast flushes the session and saveObject of
//     * BaseDaoHibernate does not.
//     *
//     * @param forecast the forecast to save
//     * @return the modified forecast (with a primary key set if they're new)
//     */
//    @Override
//    public Forecast save(Forecast forecast) {
//        return this.saveForecast(forecast);
//    }
//
//}
