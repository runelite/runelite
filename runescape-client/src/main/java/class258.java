import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
public enum class258 implements RSEnum {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3536(2, 0),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3533(1, 1),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3535(0, 2);

   @ObfuscatedName("v")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1799121535
   )
   final int field3537;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1085993091
   )
   public final int field3538;

   class258(int var3, int var4) {
      this.field3538 = var3;
      this.field3537 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "834678576"
   )
   public int rsOrdinal() {
      return this.field3537;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lid;IIIBZI)V",
      garbageValue = "1270780403"
   )
   static void method4651(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class239.field3238.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class239.field3236.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class239.field3245.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class239.field3238.put(var8, var6);
                  --class239.field3235;
                  ++class239.field3249;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class239.field3240.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class239.field3238.put(var8, var6);
                  ++class239.field3249;
               } else {
                  class239.field3242.push(var8);
                  class239.field3245.put(var8, var6);
                  ++class239.field3235;
               }

            }
         }
      }
   }
}
