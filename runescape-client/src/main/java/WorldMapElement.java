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
   @Export("__ic_m")
   public static AbstractIndexCache __ic_m;
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
   @Export("fonts")
   static Fonts fonts;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1579051565
   )
   @Export("__o")
   public final int __o;
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
   @Export("__l")
   public String __l;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -231067
   )
   @Export("__e")
   public int __e;
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
   @Export("__i")
   int[] __i;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1336803515
   )
   @Export("__a")
   int __a;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1825795359
   )
   @Export("__z")
   int __z;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1007121521
   )
   @Export("__j")
   int __j;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1209054101
   )
   @Export("__s")
   int __s;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   public class266 field3287;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public class249 field3301;
   @ObfuscatedName("h")
   @Export("__h")
   int[] __h;
   @ObfuscatedName("b")
   @Export("__b")
   byte[] __b;
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
      this.__a = Integer.MAX_VALUE;
      this.__z = Integer.MAX_VALUE;
      this.__j = Integer.MIN_VALUE;
      this.__s = Integer.MIN_VALUE;
      this.field3287 = class266.field3527;
      this.field3301 = class249.field3273;
      this.category = -1;
      this.__o = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;B)V",
      garbageValue = "81"
   )
   @Export("read")
   public void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "-1197630144"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.sprite1 = var1.__ap_310();
      } else if(var2 == 2) {
         this.sprite2 = var1.__ap_310();
      } else if(var2 == 3) {
         this.__l = var1.readStringCp1252NullTerminated();
      } else if(var2 == 4) {
         this.__e = var1.readMedium();
      } else if(var2 == 5) {
         var1.readMedium();
      } else if(var2 == 6) {
         this.textSize = var1.readUnsignedByte();
      } else {
         int var3;
         if(var2 == 7) {
            var3 = var1.readUnsignedByte();
            if((var3 & 1) == 0) {
               ;
            }

            if((var3 & 2) == 2) {
               ;
            }
         } else if(var2 == 8) {
            var1.readUnsignedByte();
         } else if(var2 >= 10 && var2 <= 14) {
            this.strings[var2 - 10] = var1.readStringCp1252NullTerminated();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.__i = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.__i[var4] = var1.__aq_303();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.__h = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.__h.length; ++var5) {
               this.__h[var5] = var1.readInt();
            }

            this.__b = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.__b[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.string1 = var1.readStringCp1252NullTerminated();
            } else if(var2 == 18) {
               var1.__ap_310();
            } else if(var2 == 19) {
               this.category = var1.__ag_302();
            } else if(var2 == 21) {
               var1.readInt();
            } else if(var2 == 22) {
               var1.readInt();
            } else if(var2 == 23) {
               var1.readUnsignedByte();
               var1.readUnsignedByte();
               var1.readUnsignedByte();
            } else if(var2 == 24) {
               var1.__aq_303();
               var1.__aq_303();
            } else if(var2 == 25) {
               var1.__ap_310();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               class266[] var6 = new class266[]{class266.field3527, class266.field3526, class266.field3529};
               this.field3287 = (class266)ScriptFrame.findEnumerated(var6, var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.field3301 = (class249)ScriptFrame.findEnumerated(UnderlayDefinition.method4839(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1799485224"
   )
   @Export("__w_409")
   public void __w_409() {
      if(this.__i != null) {
         for(int var1 = 0; var1 < this.__i.length; var1 += 2) {
            if(this.__i[var1] < this.__a) {
               this.__a = this.__i[var1];
            } else if(this.__i[var1] > this.__j) {
               this.__j = this.__i[var1];
            }

            if(this.__i[var1 + 1] < this.__z) {
               this.__z = this.__i[var1 + 1];
            } else if(this.__i[var1 + 1] > this.__s) {
               this.__s = this.__i[var1 + 1];
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
      if(var1 < 0) {
         return null;
      } else {
         Sprite var2 = (Sprite)WorldMapElement_cachedSprites.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class322.readSprite(__ic_m, var1, 0);
            if(var2 != null) {
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
   @Export("__g_410")
   public int __g_410() {
      return this.__o;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Lko;",
      garbageValue = "-31"
   )
   public static class310 method4783(int var0) {
      class310[] var1 = new class310[]{class310.field3805, class310.field3807, class310.field3806};
      class310[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class310 var4 = var2[var3];
         if(var0 == var4.field3804) {
            return var4;
         }
      }

      return null;
   }

   static {
      WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256);
   }
}
