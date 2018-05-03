import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("Size")
public class Size {
   @ObfuscatedName("ow")
   static boolean field361;
   @ObfuscatedName("rx")
   static short[] field366;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   public static final Size field365;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   public static final Size field359;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   public static final Size field360;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   @Export("listFetcher")
   static UrlRequest listFetcher;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -916308557
   )
   static int field367;
   @ObfuscatedName("z")
   final String field358;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1319477451
   )
   final int field362;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2092823011
   )
   final int field363;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1034426445
   )
   final int field364;

   static {
      field365 = new Size("SMALL", 2, 0, 4);
      field359 = new Size("MEDIUM", 0, 1, 2);
      field360 = new Size("LARGE", 1, 2, 0);
   }

   Size(String var1, int var2, int var3, int var4) {
      this.field358 = var1;
      this.field362 = var2;
      this.field363 = var3;
      this.field364 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(FB)Z",
      garbageValue = "8"
   )
   boolean method184(float var1) {
      return var1 >= (float)this.field364;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-502693213"
   )
   static void method188(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)[Lgk;",
      garbageValue = "2067329253"
   )
   static LoginPacket[] method187() {
      return new LoginPacket[]{LoginPacket.field2470, LoginPacket.field2465, LoginPacket.field2466, LoginPacket.field2468};
   }

   @ObfuscatedName("ks")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "24006"
   )
   static final void method183() {
      KeyFocusListener.method823();
      if(LoginPacket.clanMemberManager != null) {
         LoginPacket.clanMemberManager.method5519();
      }

   }
}
