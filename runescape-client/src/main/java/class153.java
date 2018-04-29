import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class153 extends class297 {
   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   @Export("platformInfo")
   static MachineInfo platformInfo;
   @ObfuscatedName("h")
   public static short[][] field2121;
   @ObfuscatedName("g")
   final boolean field2119;

   public class153(boolean var1) {
      this.field2119 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;S)I",
      garbageValue = "27280"
   )
   int method3212(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field2119?var1.field3851 - var2.field3851:var2.field3851 - var1.field3851):this.method5341(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3212((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Liv;III)Lcr;",
      garbageValue = "1117509758"
   )
   static Script method3218(class245 var0, int var1, int var2) {
      int var3 = BoundingBox2D.method40(var1, var0);
      Script var5 = (Script)Script.field1437.get((long)(var3 << 16));
      Script var4;
      if(var5 != null) {
         var4 = var5;
      } else {
         String var6 = String.valueOf(var3);
         int var7 = MapIcon.indexScripts.getFile(var6);
         if(var7 == -1) {
            var4 = null;
         } else {
            label55: {
               byte[] var8 = MapIcon.indexScripts.takeRecordFlat(var7);
               if(var8 != null) {
                  if(var8.length <= 1) {
                     var4 = null;
                     break label55;
                  }

                  var5 = SoundTaskDataProvider.newScript(var8);
                  if(var5 != null) {
                     Script.field1437.put(var5, (long)(var3 << 16));
                     var4 = var5;
                     break label55;
                  }
               }

               var4 = null;
            }
         }
      }

      if(var4 != null) {
         return var4;
      } else {
         int var12 = (var2 + 40000 << 8) + var0.field2959;
         Script var14 = (Script)Script.field1437.get((long)(var12 << 16));
         Script var13;
         if(var14 != null) {
            var13 = var14;
         } else {
            String var9 = String.valueOf(var12);
            int var10 = MapIcon.indexScripts.getFile(var9);
            if(var10 == -1) {
               var13 = null;
            } else {
               byte[] var11 = MapIcon.indexScripts.takeRecordFlat(var10);
               if(var11 != null) {
                  if(var11.length <= 1) {
                     var13 = null;
                     return var13 != null?var13:null;
                  }

                  var14 = SoundTaskDataProvider.newScript(var11);
                  if(var14 != null) {
                     Script.field1437.put(var14, (long)(var12 << 16));
                     var13 = var14;
                     return var13 != null?var13:null;
                  }
               }

               var13 = null;
            }
         }

         return var13 != null?var13:null;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-10"
   )
   static final int method3219(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var3 * (var0 & 16711935) + (var1 & 16711935) * var2 & -16711936) + ((var0 & 65280) * var3 + (var1 & 65280) * var2 & 16711680) >> 8;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "440190034"
   )
   static int method3215(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class171.intStackSize -= 2;
         var3 = class81.intStack[class171.intStackSize];
         int var4 = class81.intStack[class171.intStackSize + 1];
         if(!Client.field1094) {
            Client.cameraPitchTarget = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class81.intStack[++class171.intStackSize - 1] = Client.cameraPitchTarget;
         return 1;
      } else if(var0 == 5506) {
         class81.intStack[++class171.intStackSize - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class81.intStack[--class171.intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field927 = var3;
         return 1;
      } else if(var0 == 5531) {
         class81.intStack[++class171.intStackSize - 1] = Client.field927;
         return 1;
      } else {
         return 2;
      }
   }
}
