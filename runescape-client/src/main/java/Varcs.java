import java.io.EOFException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("q")
   @Export("intsPersistence")
   boolean[] intsPersistence;
   @ObfuscatedName("w")
   @Export("map")
   Map map;
   @ObfuscatedName("o")
   @Export("strings")
   String[] strings;
   @ObfuscatedName("u")
   @Export("unwrittenChanges")
   boolean unwrittenChanges;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 4836824701467349417L
   )
   @Export("lastWriteTimeMs")
   long lastWriteTimeMs;

   Varcs() {
      this.unwrittenChanges = false;
      int var1 = ObjectSound.archive2.getGroupFileCount(19);
      this.map = new HashMap();
      this.intsPersistence = new boolean[var1];

      int var2;
      for (var2 = 0; var2 < var1; ++var2) {
         VarcInt var3 = AbstractByteArrayCopier.getVarcInt(var2);
         this.intsPersistence[var2] = var3.persist;
      }

      var2 = 0;
      if (ObjectSound.archive2.method133(15)) {
         var2 = ObjectSound.archive2.getGroupFileCount(15);
      }

      this.strings = new String[var2];
      this.read();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "920518911"
   )
   @Export("setInt")
   void setInt(int index, int var2) {
      this.map.put(index, var2);
      if (this.intsPersistence[index]) {
         this.unwrittenChanges = true;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "6"
   )
   @Export("getInt")
   int getInt(int index) {
      Object var2 = this.map.get(index);
      return var2 instanceof Integer ? (Integer)var2 : -1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "12847051"
   )
   @Export("setString")
   void setString(int index, String var2) {
      this.map.put(index, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "897961099"
   )
   @Export("getString")
   String getString(int index) {
      Object var2 = this.map.get(index);
      return var2 instanceof String ? (String)var2 : "";
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "15"
   )
   @Export("setStringOld")
   void setStringOld(int index, String var2) {
      this.strings[index] = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "0"
   )
   @Export("getStringOld")
   String getStringOld(int index) {
      return this.strings[index];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1668901140"
   )
   @Export("clearTransient")
   void clearTransient() {
      int var1;
      for (var1 = 0; var1 < this.intsPersistence.length; ++var1) {
         if (!this.intsPersistence[var1]) {
            this.map.remove(var1);
         }
      }

      for (var1 = 0; var1 < this.strings.length; ++var1) {
         this.strings[var1] = null;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ZB)Ldk;",
      garbageValue = "8"
   )
   @Export("getPreferencesFile")
   AccessFile getPreferencesFile(boolean var1) {
      return LoginPacket.getPreferencesFile("2", WorldMapRectangle.studioGame.name, var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "370223063"
   )
   @Export("write")
   void write() {
      AccessFile var1 = this.getPreferencesFile(true);

      try {
         int var2 = 3;
         int var3 = 0;
         Iterator var4 = this.map.entrySet().iterator();

         while (var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            int var6 = (Integer)var5.getKey();
            if (this.intsPersistence[var6]) {
               Object var7 = var5.getValue();
               var2 += 3;
               if (var7 instanceof Integer) {
                  var2 += 4;
               } else if (var7 instanceof String) {
                  var2 += WorldMapRegion.stringCp1252NullTerminatedByteSize((String)var7);
               }

               ++var3;
            }
         }

         Buffer var28 = new Buffer(var2);
         var28.writeByte(2);
         var28.writeShort(var3);
         Iterator var29 = this.map.entrySet().iterator();

         label179:
         while (true) {
            Entry var8;
            int var30;
            do {
               if (!var29.hasNext()) {
                  var1.write(var28.array, 0, var28.index);
                  break label179;
               }

               var8 = (Entry)var29.next();
               var30 = (Integer)var8.getKey();
            } while(!this.intsPersistence[var30]);

            var28.writeShort(var30);
            Object var9 = var8.getValue();
            Class var10 = var9.getClass();
            class3[] var11 = class3.method34();
            int var13 = 0;

            class3 var12;
            while (true) {
               if (var13 >= var11.length) {
                  var12 = null;
                  break;
               }

               class3 var14 = var11[var13];
               if (var10 == var14.field18) {
                  var12 = var14;
                  break;
               }

               ++var13;
            }

            var28.writeByte(var12.field1147);
            Class var31 = var9.getClass();
            class3[] var32 = class3.method34();
            int var16 = 0;

            class3 var15;
            while (true) {
               if (var16 >= var32.length) {
                  var15 = null;
                  break;
               }

               class3 var17 = var32[var16];
               if (var31 == var17.field18) {
                  var15 = var17;
                  break;
               }

               ++var16;
            }

            if (var15 == null) {
               throw new IllegalArgumentException();
            }

            class0 var33 = var15.field19;
            var33.vmethod44(var9, var28);
         }
      } catch (Exception var26) {
      } finally {
         try {
            var1.close();
         } catch (Exception var25) {
         }

      }

      this.unwrittenChanges = false;
      this.lastWriteTimeMs = class203.currentTimeMs();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1824591047"
   )
   @Export("read")
   void read() {
      AccessFile var1 = this.getPreferencesFile(false);

      try {
         byte[] var2 = new byte[(int)var1.length()];

         int var3;
         for (int var4 = 0; var4 < var2.length; var4 += var3) {
            var3 = var1.read(var2, var4, var2.length - var4);
            if (var3 == -1) {
               throw new EOFException();
            }
         }

         Buffer var24 = new Buffer(var2);
         if (var24.array.length - var24.index < 1) {
            return;
         }

         int var5 = var24.readUnsignedByte();
         if (var5 < 0 || var5 > 2) {
            return;
         }

         int var6;
         int var7;
         int var8;
         int var9;
         if (var5 >= 2) {
            var9 = var24.readUnsignedShort();

            for (var6 = 0; var6 < var9; ++var6) {
               var7 = var24.readUnsignedShort();
               var8 = var24.readUnsignedByte();
               class3 var10 = (class3)ScriptFrame.findEnumerated(class3.method34(), var8);
               Object var11 = var10.method31(var24);
               if (this.intsPersistence[var7]) {
                  this.map.put(var7, var11);
               }
            }
         } else {
            var9 = var24.readUnsignedShort();

            for (var6 = 0; var6 < var9; ++var6) {
               var7 = var24.readUnsignedShort();
               var8 = var24.readInt();
               if (this.intsPersistence[var7]) {
                  this.map.put(var7, var8);
               }
            }

            var6 = var24.readUnsignedShort();

            for (var7 = 0; var7 < var6; ++var7) {
               var24.readUnsignedShort();
               var24.readStringCp1252NullTerminated();
            }
         }
      } catch (Exception var22) {
      } finally {
         try {
            var1.close();
         } catch (Exception var21) {
         }

      }

      this.unwrittenChanges = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "26563322"
   )
   @Export("tryWrite")
   void tryWrite() {
      if (this.unwrittenChanges && this.lastWriteTimeMs < class203.currentTimeMs() - 60000L) {
         this.write();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1171297883"
   )
   @Export("hasUnwrittenChanges")
   boolean hasUnwrittenChanges() {
      return this.unwrittenChanges;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;I)V",
      garbageValue = "321265868"
   )
   public static void method2160(AbstractArchive var0) {
      FloorOverlayDefinition.FloorOverlayDefinition_archive = var0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIIII[Lfy;I)V",
      garbageValue = "1119202993"
   )
   static final void method2166(byte[] var0, int var1, int var2, int var3, int var4, CollisionMap[] var5) {
      int var6;
      int var7;
      for (int var8 = 0; var8 < 4; ++var8) {
         for (var6 = 0; var6 < 64; ++var6) {
            for (var7 = 0; var7 < 64; ++var7) {
               if (var6 + var1 > 0 && var6 + var1 < 103 && var7 + var2 > 0 && var7 + var2 < 103) {
                  int[] var9 = var5[var8].flags[var6 + var1];
                  var9[var7 + var2] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for (var6 = 0; var6 < 4; ++var6) {
         for (var7 = 0; var7 < 64; ++var7) {
            for (int var11 = 0; var11 < 64; ++var11) {
               GrandExchangeOfferTotalQuantityComparator.loadTerrain(var10, var6, var7 + var1, var11 + var2, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lho;IIII)V",
      garbageValue = "1592367053"
   )
   static final void method2168(Widget var0, int var1, int var2, int var3) {
      if (var0.field968 == null) {
         throw new RuntimeException();
      } else {
         var0.field968[var1] = var2;
         var0.field969[var1] = var3;
      }
   }
}
