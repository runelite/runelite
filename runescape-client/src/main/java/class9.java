import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public abstract class class9 extends Node {
   @ObfuscatedName("rw")
   static IndexFile field254;
   @ObfuscatedName("cd")
   static IndexData field255;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   public abstract void vmethod55();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1887514532"
   )
   static final int method47(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "-1799707342"
   )
   static MessageNode method50(int var0) {
      return (MessageNode)class98.field1517.method3389((long)var0);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LIndexData;IIIBZI)V",
      garbageValue = "-538051756"
   )
   static void method52(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class234 var8 = (class234)class238.field3260.method3425(var6);
      if(var8 == null) {
         var8 = (class234)class238.field3262.method3425(var6);
         if(var8 == null) {
            var8 = (class234)class238.field3265.method3425(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3520();
                  class238.field3260.method3426(var8, var6);
                  --class238.field3261;
                  ++class238.field3267;
               }
            } else {
               if(!var5) {
                  var8 = (class234)class238.field3263.method3425(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class234();
               var8.field3218 = var0;
               var8.field3215 = var3;
               var8.field3214 = var4;
               if(var5) {
                  class238.field3260.method3426(var8, var6);
                  ++class238.field3267;
               } else {
                  class238.field3259.method3387(var8);
                  class238.field3265.method3426(var8, var6);
                  ++class238.field3261;
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "-536236074"
   )
   static int method53(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1488()?(var1.method1488()?0:1):(var1.method1488()?-1:0)):(var2 == 5?(var0.method1462()?(var1.method1462()?0:1):(var1.method1462()?-1:0)):(var2 == 6?(var0.method1469()?(var1.method1469()?0:1):(var1.method1469()?-1:0)):(var2 == 7?(var0.method1461()?(var1.method1461()?0:1):(var1.method1461()?-1:0)):var0.id - var1.id)))));
      }
   }
}
