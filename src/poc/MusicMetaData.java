package poc;

import java.io.IOException;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;

public class MusicMetaData {

	public static void main(String[] args) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {
		Mp3File mp3File = new Mp3File("D:/Songs/ENGLISH BLOOD/Birdy/Skinny Love Remixes - EP/Birdy - Skinny Love [Fareoh Remix].mp3");
		if(mp3File.hasId3v2Tag()){
			ID3v2 id3v2 = mp3File.getId3v2Tag();
			id3v2.setTrack("1");
			mp3File.save("D:/Songs/ENGLISH BLOOD/Birdy/Skinny Love Remixes - EP/Birdy - Skinny Love [Fareoh Remix].mp3");
		}
	}

}
