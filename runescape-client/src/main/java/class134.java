import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public abstract class class134 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "37"
   )
   public abstract void vmethod3137(Component var1);

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Ljava/lang/String;",
      garbageValue = "84"
   )
   static String method2868(Widget var0) {
      return class144.method3020(Projectile.method96(var0)) == 0?null:(null != var0.field2881 && var0.field2881.trim().length() != 0?var0.field2881:null);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "915472761"
   )
   public abstract int vmethod3138();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "44"
   )
   public abstract void vmethod3136(Component var1);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "4"
   )
   static final byte[] method2883(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.method2544();
      int var3 = var1.method2549();
      if(var3 >= 0 && (class170.field2716 == 0 || var3 <= class170.field2716)) {
         if(var2 == 0) {
            byte[] var4 = new byte[var3];
            var1.method2555(var4, 0, var3);
            return var4;
         } else {
            int var6 = var1.method2549();
            if(var6 < 0 || class170.field2716 != 0 && var6 > class170.field2716) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var6];
               if(var2 == 1) {
                  class120.method2517(var5, var6, var0, var3, 9);
               } else {
                  class170.field2719.method2487(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }
}
