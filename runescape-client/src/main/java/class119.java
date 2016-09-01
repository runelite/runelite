import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public class class119 {
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = -167259681
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("x")
   Inflater field2039;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 2097988503
   )
   static int field2040;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class119(int var1, int var2, int var3) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BB)V",
      garbageValue = "0"
   )
   public void method2504(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(null == this.field2039) {
            this.field2039 = new Inflater(true);
         }

         try {
            this.field2039.setInput(var1.payload, var1.offset + 10, var1.payload.length - (10 + var1.offset + 8));
            this.field2039.inflate(var2);
         } catch (Exception var4) {
            this.field2039.reset();
            throw new RuntimeException("");
         }

         this.field2039.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   public class119() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "192"
   )
   public static void method2507() {
      ItemComposition.field1159.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-1023718852"
   )
   public static void method2508(class170 var0) {
      class47.field1046 = var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)J",
      garbageValue = "116"
   )
   public static long method2509(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(1 + var5 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }
}
