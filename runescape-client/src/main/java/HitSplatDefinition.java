import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__jm_m")
   static AbstractIndexCache __jm_m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__jm_f")
   static AbstractIndexCache __jm_f;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__jm_q")
   static AbstractIndexCache __jm_q;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("HitSplatDefinition_cached")
   static EvictingDualNodeHashTable HitSplatDefinition_cached;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("__jm_o")
   static EvictingDualNodeHashTable __jm_o;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("HitSplatDefinition_cachedFonts")
   static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 431076793
   )
   @Export("fontId")
   int fontId;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1151968735
   )
   @Export("surfaceOffsetY")
   public int __n;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -102270561
   )
   @Export("__i")
   public int __i;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1533306389
   )
   @Export("__a")
   int __a;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1677628889
   )
   @Export("__z")
   int __z;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1683792491
   )
   @Export("__j")
   int __j;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1845590719
   )
   @Export("__s")
   int __s;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -389283589
   )
   @Export("__t")
   public int __t;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1751286975
   )
   @Export("__y")
   public int __y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 199815415
   )
   @Export("__h")
   public int __h;
   @ObfuscatedName("b")
   @Export("__b")
   String __b;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1003116765
   )
   @Export("__c")
   public int __c;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1498880475
   )
   @Export("__r")
   public int __r;
   @ObfuscatedName("p")
   @Export("transforms")
   public int[] transforms;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 516423393
   )
   @Export("transformVarbit")
   int transformVarbit;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1841054487
   )
   @Export("transformVarp")
   int transformVarp;

   static {
      HitSplatDefinition_cached = new EvictingDualNodeHashTable(64);
      __jm_o = new EvictingDualNodeHashTable(64);
      HitSplatDefinition_cachedFonts = new EvictingDualNodeHashTable(20);
   }

   HitSplatDefinition() {
      this.fontId = -1;
      this.__n = 16777215;
      this.__i = 70;
      this.__a = -1;
      this.__z = -1;
      this.__j = -1;
      this.__s = -1;
      this.__t = 0;
      this.__y = 0;
      this.__h = -1;
      this.__b = "";
      this.__c = -1;
      this.__r = 0;
      this.transformVarbit = -1;
      this.transformVarp = -1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "1963348982"
   )
   @Export("read")
   void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "1789835753"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.fontId = var1.__ap_310();
      } else if(var2 == 2) {
         this.__n = var1.readMedium();
      } else if(var2 == 3) {
         this.__a = var1.__ap_310();
      } else if(var2 == 4) {
         this.__j = var1.__ap_310();
      } else if(var2 == 5) {
         this.__z = var1.__ap_310();
      } else if(var2 == 6) {
         this.__s = var1.__ap_310();
      } else if(var2 == 7) {
         this.__t = var1.__aq_303();
      } else if(var2 == 8) {
         this.__b = var1.readStringCp1252NullCircumfixed();
      } else if(var2 == 9) {
         this.__i = var1.__ag_302();
      } else if(var2 == 10) {
         this.__y = var1.__aq_303();
      } else if(var2 == 11) {
         this.__h = 0;
      } else if(var2 == 12) {
         this.__c = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.__r = var1.__aq_303();
      } else if(var2 == 14) {
         this.__h = var1.__ag_302();
      } else if(var2 == 17 || var2 == 18) {
         this.transformVarbit = var1.__ag_302();
         if(this.transformVarbit == 65535) {
            this.transformVarbit = -1;
         }

         this.transformVarp = var1.__ag_302();
         if(this.transformVarp == 65535) {
            this.transformVarp = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.__ag_302();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.transforms = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.transforms[var5] = var1.__ag_302();
            if(this.transforms[var5] == 65535) {
               this.transforms[var5] = -1;
            }
         }

         this.transforms[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Ljm;",
      garbageValue = "-35"
   )
   @Export("transform")
   public final HitSplatDefinition transform() {
      int var1 = -1;
      if(this.transformVarbit != -1) {
         var1 = WorldMapSection2.getVarbit(this.transformVarbit);
      } else if(this.transformVarp != -1) {
         var1 = Varps.Varps_main[this.transformVarp];
      }

      int var2;
      if(var1 >= 0 && var1 < this.transforms.length - 1) {
         var2 = this.transforms[var1];
      } else {
         var2 = this.transforms[this.transforms.length - 1];
      }

      return var2 != -1?class72.getHitSplatDefinition(var2):null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "1000"
   )
   @Export("getString")
   public String getString(int var1) {
      String var2 = this.__b;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + ByteArrayPool.method4001(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lln;",
      garbageValue = "-1692599381"
   )
   @Export("__g_417")
   public Sprite __g_417() {
      if(this.__a < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)__jm_o.get((long)this.__a);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class322.readSprite(__jm_f, this.__a, 0);
            if(var1 != null) {
               __jm_o.put(var1, (long)this.__a);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Lln;",
      garbageValue = "-15"
   )
   @Export("__l_418")
   public Sprite __l_418() {
      if(this.__z < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)__jm_o.get((long)this.__z);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class322.readSprite(__jm_f, this.__z, 0);
            if(var1 != null) {
               __jm_o.put(var1, (long)this.__z);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Lln;",
      garbageValue = "-49"
   )
   @Export("__e_419")
   public Sprite __e_419() {
      if(this.__j < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)__jm_o.get((long)this.__j);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class322.readSprite(__jm_f, this.__j, 0);
            if(var1 != null) {
               __jm_o.put(var1, (long)this.__j);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lln;",
      garbageValue = "393569067"
   )
   @Export("__x_420")
   public Sprite __x_420() {
      if(this.__s < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)__jm_o.get((long)this.__s);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class322.readSprite(__jm_f, this.__s, 0);
            if(var1 != null) {
               __jm_o.put(var1, (long)this.__s);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lkk;",
      garbageValue = "1389815135"
   )
   @Export("getFont")
   public Font getFont() {
      if(this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)HitSplatDefinition_cachedFonts.get((long)this.fontId);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SpriteIds.method5823(__jm_f, __jm_q, this.fontId, 0);
            if(var1 != null) {
               HitSplatDefinition_cachedFonts.put(var1, (long)this.fontId);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   public static int method4972(long var0) {
      return (int)(var0 >>> 17 & 4294967295L);
   }
}
