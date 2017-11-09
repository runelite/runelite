import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("ClanMember")
public class ClanMember extends Node {
   @ObfuscatedName("d")
   static int[] field867;
   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static Widget field864;
   @ObfuscatedName("m")
   @Export("username")
   String username;
   @ObfuscatedName("p")
   String field862;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2125727289
   )
   @Export("world")
   int world;
   @ObfuscatedName("j")
   @Export("rank")
   byte rank;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Lit;",
      garbageValue = "4"
   )
   public static VarPlayerType method1228(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class51.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Liy;IIIBZI)V",
      garbageValue = "-2133602171"
   )
   static void method1227(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class245.field3322.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class245.field3318.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class245.field3321.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class245.field3322.put(var8, var6);
                  --class245.field3327;
                  ++class245.field3320;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class245.field3313.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class245.field3322.put(var8, var6);
                  ++class245.field3320;
               } else {
                  class245.field3326.push(var8);
                  class245.field3321.put(var8, var6);
                  ++class245.field3327;
               }

            }
         }
      }
   }
}
