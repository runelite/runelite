import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class1 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field10;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field2;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field7;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field3;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field4;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field5;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static final class1 field6;
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   static BuildType field1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -784823055
   )
   final int field0;

   static {
      field10 = new class1(3);
      field2 = new class1(0);
      field7 = new class1(6);
      field3 = new class1(4);
      field4 = new class1(1);
      field5 = new class1(5);
      field6 = new class1(2);
   }

   class1(int var1) {
      this.field0 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;III)Lla;",
      garbageValue = "427110378"
   )
   public static SpritePixels method1(IndexDataBase var0, int var1, int var2) {
      byte[] var4 = var0.getConfigData(var1, var2);
      boolean var3;
      if(var4 == null) {
         var3 = false;
      } else {
         Widget.decodeSprite(var4);
         var3 = true;
      }

      return !var3?null:Item.method1973();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BI)Lcj;",
      garbageValue = "-2090760675"
   )
   @Export("newScript")
   static Script newScript(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method2042(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            int var9;
            int var11;
            if(var8 > 0) {
               var11 = var8 - 1;
               var11 |= var11 >>> 1;
               var11 |= var11 >>> 2;
               var11 |= var11 >>> 4;
               var11 |= var11 >>> 8;
               var11 |= var11 >>> 16;
               int var10 = var11 + 1;
               var9 = var10;
            } else {
               var9 = 1;
            }

            IterableHashTable var13 = new IterableHashTable(var9);
            var1.switches[var7] = var13;

            while(var8-- > 0) {
               var11 = var2.readInt();
               int var12 = var2.readInt();
               var13.put(new IntegerNode(var12), (long)var11);
            }
         }
      }

      var2.offset = 0;
      var2.getNullString();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   static final void method0(int var0) {
      int[] var1 = GrandExchangeOffer.minimapSprite.pixels;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class62.tileSettings[var0][var5][var3] & 24) == 0) {
               class38.region.method2927(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class62.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               class38.region.method2927(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      GrandExchangeOffer.minimapSprite.method5833();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class62.tileSettings[var0][var6][var5] & 24) == 0) {
               BoundingBox3D.method57(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class62.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               BoundingBox3D.method57(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1048 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class38.region.method3005(Ignore.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = Spotanim.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  Client.mapIcons[Client.field1048] = Area.mapAreaType[var8].getMapIcon(false);
                  Client.field1073[Client.field1048] = var5;
                  Client.field861[Client.field1048] = var6;
                  ++Client.field1048;
               }
            }
         }
      }

      KeyFocusListener.rasterProvider.setRaster();
   }
}
