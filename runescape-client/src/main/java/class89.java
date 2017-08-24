import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class89 {
   @ObfuscatedName("i")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent;
   @ObfuscatedName("j")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      longValue = 3058820432292079519L
   )
   static long field1419;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -754303033
   )
   static int field1418;
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -2065050613
   )
   static int field1421;

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("87634f232851b5e6a0364aa35a4736c302418a5d8de44f7929399610d611e19591c975c41892b8b6541d85dbfd176b9f3c4583abc071cd84b76917ae5b75d3ccba32191ce238726bc3485dd3c09baf484d5fb43ab4f1253013ce9aabc649d9b375dfb8c7efe18db6015a565bd7c97f70d912b324a198f750c49bc604a2802909", 16);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;IIIBZI)V",
      garbageValue = "-376626977"
   )
   static void method1717(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class239.field3256.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class239.field3273.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class239.field3264.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class239.field3256.put(var8, var6);
                  --class239.field3254;
                  ++class239.field3257;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class239.field3263.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class239.field3256.put(var8, var6);
                  ++class239.field3257;
               } else {
                  class239.field3258.push(var8);
                  class239.field3264.put(var8, var6);
                  ++class239.field3254;
               }

            }
         }
      }
   }
}
