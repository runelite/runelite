import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class263 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   IndexDataBase field3627;
   @ObfuscatedName("g")
   HashMap field3626;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   IndexDataBase field3624;

   @ObfuscatedSignature(
      signature = "(Lit;Lit;)V"
   )
   public class263(IndexDataBase var1, IndexDataBase var2) {
      this.field3627 = var1;
      this.field3624 = var2;
      this.field3626 = new HashMap();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([Ljn;I)Ljava/util/HashMap;",
      garbageValue = "350472840"
   )
   public HashMap method4755(class262[] var1) {
      HashMap var2 = new HashMap();
      class262[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class262 var5 = var3[var4];
         if(this.field3626.containsKey(var5)) {
            var2.put(var5, this.field3626.get(var5));
         } else {
            IndexDataBase var7 = this.field3627;
            IndexDataBase var8 = this.field3624;
            String var9 = var5.field3619;
            int var10 = var7.getFile(var9);
            int var11 = var7.getChild(var10, "");
            Font var6 = class218.method4053(var7, var8, var10, var11);
            if(var6 != null) {
               this.field3626.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.secretPacketBuffer2.method3213();
         int var2 = Client.secretPacketBuffer2.method3213();
         var3 = Client.secretPacketBuffer2.readUnsignedShort();
         GameEngine.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               GameEngine.xteaKeys[var4][var5] = Client.secretPacketBuffer2.readInt();
            }
         }

         class56.mapRegions = new int[var3];
         BaseVarType.field27 = new int[var3];
         class5.landRegionFielIds = new int[var3];
         GameEngine.field709 = new byte[var3][];
         VarPlayerType.field3269 = new byte[var3][];
         boolean var15 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var15 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var15 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (var1 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var15 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class56.mapRegions[var3] = var7;
                  BaseVarType.field27[var3] = class158.indexMaps.getFile("m" + var5 + "_" + var6);
                  class5.landRegionFielIds[var3] = class158.indexMaps.getFile("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class31.method282(var2, var1, true);
      } else {
         var1 = Client.secretPacketBuffer2.method3213();
         boolean var14 = Client.secretPacketBuffer2.readUnsignedShortOb1() == 1;
         var3 = Client.secretPacketBuffer2.readUnsignedShort();
         var4 = Client.secretPacketBuffer2.readUnsignedShort();
         Client.secretPacketBuffer2.bitAccess();

         int var8;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.secretPacketBuffer2.getBits(1);
                  if(var8 == 1) {
                     Client.field976[var5][var6][var7] = Client.secretPacketBuffer2.getBits(26);
                  } else {
                     Client.field976[var5][var6][var7] = -1;
                  }
               }
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         GameEngine.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               GameEngine.xteaKeys[var5][var6] = Client.secretPacketBuffer2.readInt();
            }
         }

         class56.mapRegions = new int[var4];
         BaseVarType.field27 = new int[var4];
         class5.landRegionFielIds = new int[var4];
         GameEngine.field709 = new byte[var4][];
         VarPlayerType.field3269 = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.field976[var5][var6][var7];
                  if(var8 != -1) {
                     int var9 = var8 >> 14 & 1023;
                     int var10 = var8 >> 3 & 2047;
                     int var11 = (var9 / 8 << 8) + var10 / 8;

                     int var12;
                     for(var12 = 0; var12 < var4; ++var12) {
                        if(class56.mapRegions[var12] == var11) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        class56.mapRegions[var4] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        BaseVarType.field27[var4] = class158.indexMaps.getFile("m" + var12 + "_" + var13);
                        class5.landRegionFielIds[var4] = class158.indexMaps.getFile("l" + var12 + "_" + var13);
                        ++var4;
                     }
                  }
               }
            }
         }

         class31.method282(var1, var3, !var14);
      }

   }
}
