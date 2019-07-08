import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class80 {
   @ObfuscatedName("o")
   static final BigInteger field1163;
   @ObfuscatedName("u")
   static final BigInteger field1164;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1844169387"
   )
   static void method2015() {
      if (Login.field465) {
         Login.titleboxSprite = null;
         ArchiveLoader.titlebuttonSprite = null;
         WorldMapEvent.runesSprite = null;
         Login.leftTitleSprite = null;
         Fonts.rightTitleSprite = null;
         WorldMapSectionType.logoSprite = null;
         KeyHandler.title_muteSprite = null;
         Login.options_buttons_0Sprite = null;
         class308.options_buttons_2Sprite = null;
         class30.worldSelectBackSprites = null;
         Frames.worldSelectFlagSprites = null;
         AttackOption.worldSelectArrows = null;
         UrlRequest.worldSelectStars = null;
         class277.field1144 = null;
         class16.loginScreenRunesAnimation.method1762();
         AbstractSocket.method3488(2);
         UserComparator9.method3343(true);
         Login.field465 = false;
      }

   }

   static {
      field1163 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1164 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }
}
