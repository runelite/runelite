import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("WorldMapElement_archive")
   public static AbstractArchive WorldMapElement_archive;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("WorldMapElement_cachedSprites")
   static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   @Export("WorldMapElement_fonts")
   static Fonts WorldMapElement_fonts;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1579051565
   )
   public final int field1020;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2012857993
   )
   @Export("sprite1")
   public int sprite1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -322924875
   )
   @Export("sprite2")
   int sprite2;
   @ObfuscatedName("l")
   @Export("name")
   public String name;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -231067
   )
   public int field1022;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1184517129
   )
   @Export("textSize")
   public int textSize;
   @ObfuscatedName("k")
   @Export("strings")
   public String[] strings;
   @ObfuscatedName("n")
   @Export("string1")
   public String string1;
   @ObfuscatedName("i")
   int[] field1023;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1336803515
   )
   int field1024;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1825795359
   )
   int field1025;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1007121521
   )
   int field1026;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1209054101
   )
   int field1027;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("horizontalAlignment")
   public HorizontalAlignment horizontalAlignment;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("verticalAlignment")
   public VerticalAlignment verticalAlignment;
   @ObfuscatedName("h")
   int[] field1028;
   @ObfuscatedName("b")
   byte[] field1029;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -653112729
   )
   @Export("category")
   public int category;

   public WorldMapElement(int var1) {
      this.sprite1 = -1;
      this.sprite2 = -1;
      this.textSize = 0;
      this.strings = new String[5];
      this.field1024 = Integer.MAX_VALUE;
      this.field1025 = Integer.MAX_VALUE;
      this.field1026 = Integer.MIN_VALUE;
      this.field1027 = Integer.MIN_VALUE;
      this.horizontalAlignment = HorizontalAlignment.field3527;
      this.verticalAlignment = VerticalAlignment.field3273;
      this.category = -1;
      this.field1020 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;B)V",
      garbageValue = "81"
   )
   @Export("decode")
   public void decode(Buffer buffer) {
      while (true) {
         int var2 = buffer.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(buffer, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "-1197630144"
   )
   @Export("decodeNext")
   void decodeNext(Buffer buffer, int opcode) {
      if (opcode == 1) {
         this.sprite1 = buffer.method51();
      } else if (opcode == 2) {
         this.sprite2 = buffer.method51();
      } else if (opcode == 3) {
         this.name = buffer.readStringCp1252NullTerminated();
      } else if (opcode == 4) {
         this.field1022 = buffer.readMedium();
      } else if (opcode == 5) {
         buffer.readMedium();
      } else if (opcode == 6) {
         this.textSize = buffer.readUnsignedByte();
      } else {
         int var3;
         if (opcode == 7) {
            var3 = buffer.readUnsignedByte();
            if ((var3 & 1) == 0) {
            }

            if ((var3 & 2) == 2) {
            }
         } else if (opcode == 8) {
            buffer.readUnsignedByte();
         } else if (opcode >= 10 && opcode <= 14) {
            this.strings[opcode - 10] = buffer.readStringCp1252NullTerminated();
         } else if (opcode == 15) {
            var3 = buffer.readUnsignedByte();
            this.field1023 = new int[var3 * 2];

            int var4;
            for (var4 = 0; var4 < var3 * 2; ++var4) {
               this.field1023[var4] = buffer.readShort();
            }

            buffer.readInt();
            var4 = buffer.readUnsignedByte();
            this.field1028 = new int[var4];

            int var5;
            for (var5 = 0; var5 < this.field1028.length; ++var5) {
               this.field1028[var5] = buffer.readInt();
            }

            this.field1029 = new byte[var3];

            for (var5 = 0; var5 < var3; ++var5) {
               this.field1029[var5] = buffer.readByte();
            }
         } else if (opcode != 16) {
            if (opcode == 17) {
               this.string1 = buffer.readStringCp1252NullTerminated();
            } else if (opcode == 18) {
               buffer.method51();
            } else if (opcode == 19) {
               this.category = buffer.readUnsignedShort();
            } else if (opcode == 21) {
               buffer.readInt();
            } else if (opcode == 22) {
               buffer.readInt();
            } else if (opcode == 23) {
               buffer.readUnsignedByte();
               buffer.readUnsignedByte();
               buffer.readUnsignedByte();
            } else if (opcode == 24) {
               buffer.readShort();
               buffer.readShort();
            } else if (opcode == 25) {
               buffer.method51();
            } else if (opcode == 28) {
               buffer.readUnsignedByte();
            } else if (opcode == 29) {
               HorizontalAlignment[] var6 = new HorizontalAlignment[]{HorizontalAlignment.field3527, HorizontalAlignment.field3526, HorizontalAlignment.field3529};
               this.horizontalAlignment = (HorizontalAlignment)ScriptFrame.findEnumerated(var6, buffer.readUnsignedByte());
            } else if (opcode == 30) {
               this.verticalAlignment = (VerticalAlignment)ScriptFrame.findEnumerated(FloorUnderlayDefinition.method4839(), buffer.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1799485224"
   )
   public void method389() {
      if (this.field1023 != null) {
         for (int var1 = 0; var1 < this.field1023.length; var1 += 2) {
            if (this.field1023[var1] < this.field1024) {
               this.field1024 = this.field1023[var1];
            } else if (this.field1023[var1] > this.field1026) {
               this.field1026 = this.field1023[var1];
            }

            if (this.field1023[var1 + 1] < this.field1025) {
               this.field1025 = this.field1023[var1 + 1];
            } else if (this.field1023[var1 + 1] > this.field1027) {
               this.field1027 = this.field1023[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZI)Lln;",
      garbageValue = "628564789"
   )
   @Export("getSprite")
   public Sprite getSprite(boolean var1) {
      int var2 = this.sprite1;
      return this.getSprite0(var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Lln;",
      garbageValue = "-34"
   )
   @Export("getSprite0")
   Sprite getSprite0(int var1) {
      if (var1 < 0) {
         return null;
      } else {
         Sprite var2 = (Sprite)WorldMapElement_cachedSprites.get((long)var1);
         if (var2 != null) {
            return var2;
         } else {
            var2 = class322.readSprite(WorldMapElement_archive, var1, 0);
            if (var2 != null) {
               WorldMapElement_cachedSprites.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "821701099"
   )
   public int method390() {
      return this.field1020;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Lko;",
      garbageValue = "-31"
   )
   public static class310 method4783(int var0) {
      class310[] var1 = new class310[]{class310.field3805, class310.field3807, class310.field3806};
      class310[] var2 = var1;

      for (int var3 = 0; var3 < var2.length; ++var3) {
         class310 var4 = var2[var3];
         if (var0 == var4.field3804) {
            return var4;
         }
      }

      return null;
   }

   static {
      WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256);
   }
}
