package log.pattern.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtil {

	public static List<Object> beginMethod(String textLog) {
		StopWatch sw = new StopWatch(textLog);
		sw.start();
		textLog = String.format("<<<<< %s >>>>>", textLog);
		int size = textLog.length();
		log.info("=".repeat(size));
		log.info(textLog);
		log.info("=".repeat(size));
		List<Object> list = new ArrayList<>();
		list.add((Object) size);
		list.add((Object) sw);
		return list;
	}

	public static List<Object> litenService(String textLog) {
		StopWatch sw = new StopWatch(textLog);
		sw.start();
		textLog = String.format("<<<<< %s >>>>>", textLog);
		int size = textLog.length();
		log.info("-".repeat(size));
		log.info(textLog);
		log.info("-".repeat(size));
		List<Object> list = new ArrayList<>();
		list.add((Object) size);
		list.add((Object) sw);
		return list;
	}

	public static void logTime(List<Object> list, boolean isEndMethod) {
		int size = (int) list.get(0);
		StopWatch sw = (StopWatch) list.get(1);
		sw.stop();
		log.info(String.format("%s - TEMPO: %s", sw.getId(), sw.getTotalTimeSeconds()));
		if (isEndMethod) {
			int metade1 = (size - 5) / 2;
			int metade2 = (size % 2 == 0) ? metade1 : metade1 + 1;
			log.info(String.format("%s%s%s", "=".repeat(metade1), " FIM ", "=".repeat(metade2)));
		} else {
			log.info("-".repeat(size));
		}
	}

}
