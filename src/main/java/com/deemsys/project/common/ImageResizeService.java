package com.deemsys.project.common;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImageResizeService {
	
	@SuppressWarnings("unused")
	public BufferedImage resizeImage(BufferedImage originalImage,int IMG_WIDTH,int IMG_HEIGHT,int type){
			BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
			g.dispose();
				
			return resizedImage;
	}
}
