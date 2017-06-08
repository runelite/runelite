import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
public class class241 extends CacheableNode {
   @ObfuscatedName("ez")
   static Font field3288;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2107558689
   )
   public static int field3289;
   @ObfuscatedName("i")
   public static NodeCache field3290;
   @ObfuscatedName("n")
   public static IndexDataBase field3291;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2082064457
   )
   public int field3292;
   @ObfuscatedName("c")
   public static int[] field3293;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-814824984"
   )
   void method4300(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field3292 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-88"
   )
   void method4301(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4300(var1, var2);
      }
   }

   class241() {
      this.field3292 = 0;
   }

   static {
      field3290 = new NodeCache(64);
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-805356056"
   )
   static final boolean method4308(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field966 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1188.method3973(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1188.method3986(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1188.method3975(false);
         }

         if(var1 == 325) {
            Client.field1188.method3975(true);
         }

         if(var1 == 326) {
            Client.secretPacketBuffer1.putOpcode(146);
            Client.field1188.method3976(Client.secretPacketBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }
}
