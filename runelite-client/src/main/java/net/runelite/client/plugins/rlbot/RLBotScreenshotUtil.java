package net.runelite.client.plugins.rlbot;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import javax.imageio.ImageIO;
import lombok.RequiredArgsConstructor;
import net.runelite.client.ui.DrawManager;

/**
 * Utility class for handling screenshots for the RLBot plugin.
 * Provides methods for capturing, processing, and encoding screenshots.
 */
@RequiredArgsConstructor
public class RLBotScreenshotUtil {
    
    /**
     * The draw manager used to capture screenshots.
     */
    private final DrawManager drawManager;
    
    /**
     * The logger used for logging.
     */
    private final RLBotLogger logger;
    
    /**
     * The plugin configuration.
     */
    private final RLBotConfig config;
    
    // Image format constants
    private static final String IMAGE_FORMAT = "png";
    private static final String SCREENSHOT_PREFIX = "screenshot_";
    
    /**
     * Captures a screenshot and processes it.
     * 
     * @param screenshotHandler The handler to process the screenshot with
     */
    public void captureScreenshot(ScreenshotHandler screenshotHandler) {
        drawManager.requestNextFrameListener(image -> {
            // Process the screenshot
            BufferedImage resizedImage = resizeImage(image);
            
            // Save screenshot if enabled
            if (config.saveScreenshots()) {
                saveScreenshotSafely(resizedImage);
            }
            
            // Encode the screenshot
            String encodedImage = encodeImageSafely(resizedImage);
            if (encodedImage != null) {
                // Handle the processed screenshot
                screenshotHandler.handle(encodedImage);
            } else {
                logger.error("Failed to encode screenshot");
            }
        });
    }
    
    /**
     * Resizes an image to the configured dimensions.
     * 
     * @param originalImage The original image
     * @return The resized image
     */
    private BufferedImage resizeImage(Image originalImage) {
        // Create a new buffered image with the specified dimensions
        BufferedImage resizedImage = new BufferedImage(
            RLBotConstants.SCREENSHOT_WIDTH,
            RLBotConstants.SCREENSHOT_HEIGHT,
            BufferedImage.TYPE_INT_RGB
        );
        
        // Draw the original image onto the new image
        Graphics2D graphics = resizedImage.createGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, RLBotConstants.SCREENSHOT_WIDTH, RLBotConstants.SCREENSHOT_HEIGHT);
        graphics.drawImage(
            originalImage,
            0, 0, RLBotConstants.SCREENSHOT_WIDTH, RLBotConstants.SCREENSHOT_HEIGHT,
            null
        );
        graphics.dispose();
        
        return resizedImage;
    }
    
    /**
     * Saves a screenshot to the screenshots directory.
     * 
     * @param image The image to save
     * @throws IOException If an error occurs while saving the screenshot
     */
    private void saveScreenshot(BufferedImage image) throws IOException {
        // Create the screenshots directory if it doesn't exist
        File screenshotsDir = new File(RLBotConstants.SCREENSHOTS_DIR);
        if (!screenshotsDir.exists()) {
            if (!screenshotsDir.mkdirs()) {
                logger.error("Failed to create screenshots directory");
                return;
            }
        }
        
        // Generate a file name with timestamp
        String fileName = String.format(
            "screenshot_%s.png",
            LocalDateTime.now().format(RLBotConstants.DATE_FORMAT_FILE)
        );
        File outputFile = new File(screenshotsDir, fileName);
        
        // Save the image
        ImageIO.write(image, "png", outputFile);
        logger.debug("Screenshot saved to " + outputFile.getAbsolutePath());
    }
    
    /**
     * Encodes an image to a base64 string.
     * 
     * @param image The image to encode
     * @return The encoded image
     * @throws IOException If an error occurs while encoding the image
     */
    private String encodeImage(BufferedImage image) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }
    
    /**
     * Safely saves a screenshot, handling any exceptions internally.
     * 
     * @param image The image to save
     */
    private void saveScreenshotSafely(BufferedImage image) {
        try {
            saveScreenshot(image);
        } catch (IOException e) {
            logger.error("Error saving screenshot: " + e.getMessage());
        }
    }
    
    /**
     * Safely encodes an image, handling any exceptions internally.
     * 
     * @param image The image to encode
     * @return The encoded image, or null if encoding failed
     */
    private String encodeImageSafely(BufferedImage image) {
        try {
            return encodeImage(image);
        } catch (IOException e) {
            logger.error("Error encoding screenshot: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Interface for handling processed screenshots.
     */
    public interface ScreenshotHandler {
        /**
         * Handles a processed screenshot.
         * 
         * @param encodedImage The base64 encoded image
         */
        void handle(String encodedImage);
    }
} 