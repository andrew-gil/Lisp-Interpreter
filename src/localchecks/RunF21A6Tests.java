package localchecks;
import grader.basics.execution.BasicProjectExecution;
import gradingTools.comp524f21.assignment6.F21Assignment6Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
public class RunF21A6Tests {
	//static final String PROJECT_LOCATION = "C:\\Users\\hello\\21workspace\\524a5SML"; //Your location will be different
	public static void main(String[] args) {
		// if you set this to false, grader steps will not be traced
		GraderBasicsTraceUtility.setTracerShowInfo(true);	
		// if you set this to false, all grader steps will be traced,
		// not just the ones that failed		
		GraderBasicsTraceUtility.setBufferTracedMessages(true);
		// Change this number if a test trace gets longer than 600 and is clipped
		GraderBasicsTraceUtility.setMaxPrintedTraces(600);
		// Change this number if all traces together are longer than 2000
		GraderBasicsTraceUtility.setMaxTraces(2000);
		// Change this number if your process times out prematurely
		BasicProjectExecution.setProcessTimeOut(5);
		//F21Assignment5Suite.setProjectLocation(PROJECT_LOCATION);
		// You need to always call such a method
		F21Assignment6Suite.main(args);
	}
}
