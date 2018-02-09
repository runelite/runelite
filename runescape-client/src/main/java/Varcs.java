import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("m")
   @Export("varcSerials")
   boolean[] varcSerials;
   @ObfuscatedName("h")
   @Export("varcstringSerials")
   boolean[] varcstringSerials;
   @ObfuscatedName("i")
   @Export("varcs")
   int[] varcs;
   @ObfuscatedName("w")
   @Export("varcstrings")
   String[] varcstrings;
   @ObfuscatedName("t")
   @Export("changed")
   boolean changed;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -116963315871757039L
   )
   @Export("lastSerialize")
   long lastSerialize;

   Varcs() {
      this.changed = false;
      this.varcs = new int[Frames.configsIndex.fileCount(19)];
      this.varcstrings = new String[Frames.configsIndex.fileCount(15)];
      this.varcSerials = new boolean[this.varcs.length];

      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         class254 var2 = class250.method4656(var1);
         this.varcSerials[var1] = var2.field3398;
      }

      this.varcstringSerials = new boolean[this.varcstrings.length];

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         class255 var3 = IndexData.method4624(var1);
         this.varcstringSerials[var1] = var3.field3403;
      }

      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         this.varcs[var1] = -1;
      }

      this.deserialize();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-19207"
   )
   @Export("putVarc")
   void putVarc(int var1, int var2) {
      this.varcs[var1] = var2;
      if(this.varcSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1355638292"
   )
   @Export("getVarc")
   int getVarc(int var1) {
      return this.varcs[var1];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1825547234"
   )
   @Export("putVarcString")
   void putVarcString(int var1, String var2) {
      this.varcstrings[var1] = var2;
      if(this.varcstringSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "47"
   )
   @Export("getVarcString")
   String getVarcString(int var1) {
      return this.varcstrings[var1];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-13"
   )
   @Export("reset")
   void reset() {
      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         if(!this.varcSerials[var1]) {
            this.varcs[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         if(!this.varcstringSerials[var1]) {
            this.varcstrings[var1] = null;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZI)Lcs;",
      garbageValue = "-2124780357"
   )
   @Export("getVarPrefs")
   FileOnDisk getVarPrefs(boolean var1) {
      return VertexNormal.getPreferencesFile("2", AbstractSoundSystem.field1553.name, var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-851191154"
   )
   @Export("serialize")
   void serialize() {
      FileOnDisk var1 = this.getVarPrefs(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.varcs.length; ++var4) {
            if(this.varcSerials[var4] && this.varcs[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.varcstrings.length; ++var5) {
            if(this.varcstringSerials[var5] && this.varcstrings[var5] != null) {
               var2 += 2 + FrameMap.getLength(this.varcstrings[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.putByte(1);
         var9.putShort(var3);

         int var6;
         for(var6 = 0; var6 < this.varcs.length; ++var6) {
            if(this.varcSerials[var6] && this.varcs[var6] != -1) {
               var9.putShort(var6);
               var9.putInt(this.varcs[var6]);
            }
         }

         var9.putShort(var4);

         for(var6 = 0; var6 < this.varcstrings.length; ++var6) {
            if(this.varcstringSerials[var6] && this.varcstrings[var6] != null) {
               var9.putShort(var6);
               var9.putString(this.varcstrings[var6]);
            }
         }

         var1.write(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.close();
         } catch (Exception var16) {
            ;
         }

      }

      this.changed = false;
      this.lastSerialize = SceneTilePaint.currentTimeMs();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-34"
   )
   @Export("deserialize")
   void deserialize() {
      FileOnDisk var1 = this.getVarPrefs(false);

      try {
         byte[] var2 = new byte[(int)var1.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var1.read(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new EOFException();
            }
         }

         Buffer var13 = new Buffer(var2);
         if(var13.payload.length - var13.offset < 1) {
            return;
         }

         int var14 = var13.readUnsignedByte();
         if(var14 < 0 || var14 > 1) {
            return;
         }

         int var15 = var13.readUnsignedShort();

         int var7;
         int var8;
         int var9;
         for(var7 = 0; var7 < var15; ++var7) {
            var8 = var13.readUnsignedShort();
            var9 = var13.readInt();
            if(this.varcSerials[var8]) {
               this.varcs[var8] = var9;
            }
         }

         var7 = var13.readUnsignedShort();

         for(var8 = 0; var8 < var7; ++var8) {
            var9 = var13.readUnsignedShort();
            String var10 = var13.readString();
            if(this.varcstringSerials[var9]) {
               this.varcstrings[var9] = var10;
            }
         }
      } catch (Exception var24) {
         ;
      } finally {
         try {
            var1.close();
         } catch (Exception var23) {
            ;
         }

      }

      this.changed = false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   @Export("process")
   void process() {
      if(this.changed && this.lastSerialize < SceneTilePaint.currentTimeMs() - 60000L) {
         this.serialize();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "443545917"
   )
   @Export("changed")
   boolean changed() {
      return this.changed;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "1781455247"
   )
   static int method1997(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class94.field1418:ItemLayer.field1668;
      if(var0 == 1800) {
         int[] var4 = class80.intStack;
         int var5 = ++class80.intStackSize - 1;
         int var7 = WorldComparator.getWidgetConfig(var3);
         int var6 = var7 >> 11 & 63;
         var4[var5] = var6;
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.name == null) {
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
            } else {
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var8 = class80.intStack[--class80.intStackSize];
         --var8;
         if(var3.actions != null && var8 < var3.actions.length && var3.actions[var8] != null) {
            class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var3.actions[var8];
         } else {
            class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "25132"
   )
   static void method1998(int var0) {
      if(var0 == -1 && !Client.field1059) {
         class25.field356.method4139();
         class214.field2617 = 1;
         class214.field2614 = null;
      } else if(var0 != -1 && var0 != Client.field902 && Client.field1057 != 0 && !Client.field1059) {
         DState.method3488(2, class231.indexTrack1, var0, 0, Client.field1057, false);
      }

      Client.field902 = var0;
   }
}
