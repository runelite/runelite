import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class38 {
   @ObfuscatedName("gq")
   static Widget field786;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1072354677
   )
   int field787;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2088331513
   )
   int field788;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 772990287
   )
   int field789;
   @ObfuscatedName("a")
   String field790;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 888762481
   )
   int field791;
   @ObfuscatedName("x")
   public static short[][] field793;
   @ObfuscatedName("pl")
   static class30 field794;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "1305647109"
   )
   static final boolean method720(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label88:
      while(true) {
         int var6 = var4.method2735();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2735();
               if(var9 == 0) {
                  continue label88;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var1 + var11;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = class143.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.field299 || var15.field2910 != 0 || var15.field2916 == 1 || var15.field2904) {
                     if(!var15.method3499()) {
                        ++Client.field350;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2735();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "302528088"
   )
   public static void method721() {
      if(class185.field2755 != null) {
         class185.field2755.method2006();
      }

   }
}
