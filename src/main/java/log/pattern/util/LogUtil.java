package log.pattern.util;

import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtil {

	public static int beginMethod(String textLog) {
		textLog = String.format("<<<<< %s >>>>>", textLog);
		int size = textLog.length();
		log.info("=".repeat(size));
		log.info(textLog);
		log.info("=".repeat(size));
		return size;
	}

	public static int litenService(String textLog) {
		textLog = String.format("<<<<< %s >>>>>", textLog);
		int size = textLog.length();
		log.info("-".repeat(size));
		log.info(textLog);
		log.info("-".repeat(size));
		return size;
	}

	public static void logTime(StopWatch sw, int size, boolean isEndMethod) {
		sw.stop();
		log.info(String.format("%s - TEMPO: %s", sw.getId(), sw.getTotalTimeSeconds()));
		int metade1 = (size - 5) / 2;
		int metade2 = (size % 2 == 0) ? metade1 : metade1 + 1;
		if (isEndMethod) {
			log.info("=".repeat(metade1) + " FIM " + "=".repeat(metade2));
		} else {
			log.info("-".repeat(size));
		}
	}

}
