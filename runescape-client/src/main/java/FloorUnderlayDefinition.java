import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1495728371
   )
   public int field2812;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1383386977
   )
   int field2813 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -957611679
   )
   public int field2814;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1282425495
   )
   public int field2815;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 978239695
   )
   public int field2816;
   @ObfuscatedName("d")
   public static NodeCache field2817 = new NodeCache(64);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "322658869"
   )
   public void method3484() {
      this.method3487(this.field2813);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1671412801"
   )
   public void method3485(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3486(var1, var3, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "1031091663"
   )
   void method3486(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field2813 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   void method3487(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field2812 = (int)(var14 * 256.0D);
      this.field2816 = (int)(256.0D * var16);
      if(this.field2812 < 0) {
         this.field2812 = 0;
      } else if(this.field2812 > 255) {
         this.field2812 = 255;
      }

      if(this.field2816 < 0) {
         this.field2816 = 0;
      } else if(this.field2816 > 255) {
         this.field2816 = 255;
      }

      if(var16 > 0.5D) {
         this.field2815 = (int)(512.0D * (1.0D - var16) * var14);
      } else {
         this.field2815 = (int)(512.0D * var14 * var16);
      }

      if(this.field2815 < 1) {
         this.field2815 = 1;
      }

      this.field2814 = (int)(var12 * (double)this.field2815);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass18;I)V",
      garbageValue = "-2040578708"
   )
   static void method3491(class18 var0) {
      class174.method3275(var0, 200000);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)LMessageNode;",
      garbageValue = "-1532659320"
   )
   static MessageNode method3496(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      return var2.method975(var1);
   }
}
