import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("d")
   static boolean field1528;
   @ObfuscatedName("s")
   @Export("blendedHue")
   static int[] blendedHue;
   @ObfuscatedName("q")
   @Export("changed")
   boolean changed;
   @ObfuscatedName("n")
   @Export("varcstrings")
   String[] varcstrings;
   @ObfuscatedName("o")
   @Export("varcs")
   int[] varcs;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 112025426178219883L
   )
   @Export("lastSerialize")
   long lastSerialize;
   @ObfuscatedName("a")
   @Export("varcSerials")
   boolean[] varcSerials;
   @ObfuscatedName("r")
   @Export("varcstringSerials")
   boolean[] varcstringSerials;

   Varcs() {
      this.changed = false;
      this.varcs = new int[GameEngine.configsIndex.fileCount(19)];
      this.varcstrings = new String[GameEngine.configsIndex.fileCount(15)];
      this.varcSerials = new boolean[this.varcs.length];

      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         class244 var3 = (class244)class244.field3315.get((long)var1);
         class244 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            byte[] var4 = class244.field3317.getConfigData(19, var1);
            var3 = new class244();
            if(var4 != null) {
               var3.method4316(new Buffer(var4));
            }

            class244.field3315.put(var3, (long)var1);
            var2 = var3;
         }

         this.varcSerials[var1] = var2.field3316;
      }

      this.varcstringSerials = new boolean[this.varcstrings.length];

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         class245 var5 = class28.method270(var1);
         this.varcstringSerials[var1] = var5.field3322;
      }

      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         this.varcs[var1] = -1;
      }

      this.deserialize();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZB)Ldc;",
      garbageValue = "-11"
   )
   @Export("getVarPrefs")
   FileOnDisk getVarPrefs(boolean var1) {
      return class163.getPreferencesFile("2", class56.field695.field3199, var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1602688718"
   )
   @Export("changed")
   boolean changed() {
      return this.changed;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "20"
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
               var2 += 2 + ClanMember.getLength(this.varcstrings[var5]);
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
      this.lastSerialize = class45.currentTimeMs();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-9413"
   )
   @Export("deserialize")
   void deserialize() {
      FileOnDisk var1 = this.getVarPrefs(false);

      label186: {
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

            int var5 = var13.readUnsignedByte();
            if(var5 >= 0 && var5 <= 1) {
               int var6 = var13.readUnsignedShort();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var13.readUnsignedShort();
                  var9 = var13.readInt();
                  if(this.varcSerials[var8]) {
                     this.varcs[var8] = var9;
                  }
               }

               var7 = var13.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label186;
                  }

                  var9 = var13.readUnsignedShort();
                  String var10 = var13.readString();
                  if(this.varcstringSerials[var9]) {
                     this.varcstrings[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label186;
         } finally {
            try {
               var1.close();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.changed = false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-942099417"
   )
   @Export("getVarcString")
   String getVarcString(int var1) {
      return this.varcstrings[var1];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1252299492"
   )
   @Export("putVarc")
   void putVarc(int var1, int var2) {
      this.varcs[var1] = var2;
      if(this.varcSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-166229568"
   )
   @Export("getVarc")
   int getVarc(int var1) {
      return this.varcs[var1];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-706334496"
   )
   @Export("putVarcString")
   void putVarcString(int var1, String var2) {
      this.varcstrings[var1] = var2;
      if(this.varcstringSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1537548538"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   @Export("process")
   void process() {
      if(this.changed && this.lastSerialize < class45.currentTimeMs() - 60000L) {
         this.serialize();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "119837446"
   )
   static int method1842(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class31.field452:class23.field366;
      if(var0 == 1600) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 1606) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.field2690;
         return 1;
      } else if(var0 == 1611) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.field2684;
         return 1;
      } else if(var0 == 1613) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.field2688.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)Lhx;",
      garbageValue = "-52"
   )
   public static Widget method1849(int var0, int var1) {
      Widget var2 = GZipDecompressor.method3177(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }
}
