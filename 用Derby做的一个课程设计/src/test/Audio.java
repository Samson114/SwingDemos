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
			// ����������һ��Ƶ�ļ� 
			InputStream in = new FileInputStream(Filename);//FIlename ������ص������ļ���(��game.wav��) 
			// ���������д���һ��AudioStream���� 
			AudioStream as = new AudioStream(in); 
			AudioPlayer.player.start(as);//�þ�̬��Աplayer.start�������� 
//			AudioPlayer.player.stop(as);//�ر����ֲ��� 
			//���Ҫʵ��ѭ�����ţ��������������ȡ������ġ�AudioPlayer.player.start(as);����� 
			/*AudioData data = as.getData(); 
			ContinuousAudioDataStream gg= new ContinuousAudioDataStream (data); 
			AudioPlayer.player.start(gg);// Play audio. 
			*/ 
			//���Ҫ��һ�� URL ��Ϊ��������Դ(source)����������Ĵ�����ʾ�滻�������������������� 
			/*AudioStream as = new AudioStream (url.openStream()); 
			*/ 
		} catch(FileNotFoundException e){ 
			System.out.print("FileNotFoundException "); 
		} catch(IOException e){ 
			System.out.print("�д���!"); 
		} 
	}

}