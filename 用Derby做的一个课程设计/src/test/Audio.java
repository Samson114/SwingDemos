package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Audio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	
		String Filename="D:\\0bishe\\11.wav";
		
		try{ 
			// 用输入流打开一音频文件 
			InputStream in = new FileInputStream(Filename);//FIlename 是你加载的声音文件如(“game.wav”) 
			// 从输入流中创建一个AudioStream对象 
			AudioStream as = new AudioStream(in); 
			AudioPlayer.player.start(as);//用静态成员player.start播放音乐 
//			AudioPlayer.player.stop(as);//关闭音乐播放 
			//如果要实现循环播放，则用下面的三句取代上面的“AudioPlayer.player.start(as);”这句 
			/*AudioData data = as.getData(); 
			ContinuousAudioDataStream gg= new ContinuousAudioDataStream (data); 
			AudioPlayer.player.start(gg);// Play audio. 
			*/ 
			//如果要用一个 URL 做为声音流的源(source)，则用下面的代码所示替换输入流来创建声音流： 
			/*AudioStream as = new AudioStream (url.openStream()); 
			*/ 
		} catch(FileNotFoundException e){ 
			System.out.print("FileNotFoundException "); 
		} catch(IOException e){ 
			System.out.print("有错误!"); 
		} 
	}

}