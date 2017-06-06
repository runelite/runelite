import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class243 extends CacheableNode {
   @ObfuscatedName("c")
   public static NodeCache field3312;
   @ObfuscatedName("e")
   public boolean field3314;
   @ObfuscatedName("i")
   public static IndexDataBase field3316;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "602"
   )
   public void method4316(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4317(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "679762014"
   )
   void method4317(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3314 = true;
      }

   }

   static {
      field3312 = new NodeCache(64);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2062675851"
   )
   static void method4319(Component var0) {
      var0.addMouseListener(class59.mouse);
      var0.addMouseMotionListener(class59.mouse);
      var0.addFocusListener(class59.mouse);
   }

   public class243() {
      this.field3314 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "-51"
   )
   public static String method4326(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class266.field3661[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)LSpritePixels;",
      garbageValue = "1731326507"
   )
   public static SpritePixels method4328(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4125(var1);
      int var4 = var0.method4126(var3, var2);
      return GameEngine.method827(var0, var3, var4);
   }
}
