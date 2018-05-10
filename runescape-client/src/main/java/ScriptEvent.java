import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("rl")
   @ObfuscatedGetter(
      intValue = -902649341
   )
   static int field522;
   @ObfuscatedName("by")
   static String field521;
   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("w")
   @Export("params")
   Object[] params;
   @ObfuscatedName("m")
   @Export("boolean1")
   boolean boolean1;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("source")
   Widget source;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -411332337
   )
   @Export("mouseX")
   int mouseX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1874529329
   )
   @Export("mouseY")
   int mouseY;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1125388097
   )
   @Export("op")
   int op;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("target")
   Widget target;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1655578203
   )
   @Export("typedKeyCode")
   int typedKeyCode;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 866882175
   )
   @Export("typedKeyChar")
   int typedKeyChar;
   @ObfuscatedName("a")
   @Export("opbase")
   String opbase;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 847405195
   )
   int field519;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -652399611
   )
   int field518;

   public ScriptEvent() {
      this.field518 = 76;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "-1794033575"
   )
   public void method1078(Object[] var1) {
      this.params = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-26624"
   )
   public void method1079(int var1) {
      this.field518 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-124"
   )
   public static int method1084(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(ZLge;I)V",
      garbageValue = "-435874001"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0, PacketBuffer var1) {
      Client.isDynamicRegion = var0;
      int var2;
      int var3;
      int var5;
      int var6;
      int var7;
      int var8;
      if(!Client.isDynamicRegion) {
         var2 = var1.readUnsignedShort();
         var3 = var1.readUnsignedShort();
         int var4 = var1.readUnsignedShort();
         GameEngine.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               GameEngine.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         OwnWorldComparator.mapRegions = new int[var4];
         class140.landMapFileIds = new int[var4];
         ItemContainer.landRegionFileIds = new int[var4];
         class8.field58 = new byte[var4][];
         ItemLayer.field1475 = new byte[var4][];
         boolean var16 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var3 / 8 == 48) {
            var16 = true;
         }

         if(var2 / 8 == 48 && var3 / 8 == 148) {
            var16 = true;
         }

         var4 = 0;

         for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
            for(var7 = (var3 - 6) / 8; var7 <= (var3 + 6) / 8; ++var7) {
               var8 = var7 + (var6 << 8);
               if(!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
                  OwnWorldComparator.mapRegions[var4] = var8;
                  class140.landMapFileIds[var4] = class234.indexMaps.getFile("m" + var6 + "_" + var7);
                  ItemContainer.landRegionFileIds[var4] = class234.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         ClanMemberManager.method5501(var2, var3, true);
      } else {
         var2 = var1.method3562();
         var3 = var1.method3676();
         boolean var15 = var1.method3553() == 1;
         var5 = var1.readUnsignedShort();
         var1.bitAccess();

         int var9;
         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = var1.getBits(1);
                  if(var9 == 1) {
                     Client.instanceTemplateChunks[var6][var7][var8] = var1.getBits(26);
                  } else {
                     Client.instanceTemplateChunks[var6][var7][var8] = -1;
                  }
               }
            }
         }

         var1.byteAccess();
         GameEngine.xteaKeys = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               GameEngine.xteaKeys[var6][var7] = var1.readInt();
            }
         }

         OwnWorldComparator.mapRegions = new int[var5];
         class140.landMapFileIds = new int[var5];
         ItemContainer.landRegionFileIds = new int[var5];
         class8.field58 = new byte[var5][];
         ItemLayer.field1475 = new byte[var5][];
         var5 = 0;

         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = Client.instanceTemplateChunks[var6][var7][var8];
                  if(var9 != -1) {
                     int var10 = var9 >> 14 & 1023;
                     int var11 = var9 >> 3 & 2047;
                     int var12 = (var10 / 8 << 8) + var11 / 8;

                     int var13;
                     for(var13 = 0; var13 < var5; ++var13) {
                        if(OwnWorldComparator.mapRegions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        OwnWorldComparator.mapRegions[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        class140.landMapFileIds[var5] = class234.indexMaps.getFile("m" + var13 + "_" + var14);
                        ItemContainer.landRegionFileIds[var5] = class234.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         ClanMemberManager.method5501(var2, var3, !var15);
      }

   }
}
