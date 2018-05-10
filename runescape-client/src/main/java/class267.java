import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
public class class267 extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   static IndexDataBase field3386;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   static IndexDataBase field3366;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   static NodeCache field3367;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   static NodeCache field3368;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   static NodeCache field3369;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1172601793
   )
   int field3373;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 925164125
   )
   public int field3374;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1038044271
   )
   public int field3375;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 43365149
   )
   int field3376;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1209890703
   )
   int field3377;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1467718321
   )
   int field3378;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 959206911
   )
   int field3379;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -535619493
   )
   public int field3371;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -753785695
   )
   public int field3381;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1772931603
   )
   public int field3370;
   @ObfuscatedName("z")
   String field3365;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2043201199
   )
   public int field3384;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2068012815
   )
   public int field3385;
   @ObfuscatedName("v")
   public int[] field3383;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 612297757
   )
   int field3387;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1936569109
   )
   int field3382;

   static {
      field3367 = new NodeCache(64);
      field3368 = new NodeCache(64);
      field3369 = new NodeCache(20);
   }

   class267() {
      this.field3373 = -1;
      this.field3374 = 16777215;
      this.field3375 = 70;
      this.field3376 = -1;
      this.field3377 = -1;
      this.field3378 = -1;
      this.field3379 = -1;
      this.field3371 = 0;
      this.field3381 = 0;
      this.field3370 = -1;
      this.field3365 = "";
      this.field3384 = -1;
      this.field3385 = 0;
      this.field3387 = -1;
      this.field3382 = -1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1512059909"
   )
   void method5010(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method5009(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-1469675978"
   )
   void method5009(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3373 = var1.method3585();
      } else if(var2 == 2) {
         this.field3374 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3376 = var1.method3585();
      } else if(var2 == 4) {
         this.field3378 = var1.method3585();
      } else if(var2 == 5) {
         this.field3377 = var1.method3585();
      } else if(var2 == 6) {
         this.field3379 = var1.method3585();
      } else if(var2 == 7) {
         this.field3371 = var1.readShort();
      } else if(var2 == 8) {
         this.field3365 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3375 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3381 = var1.readShort();
      } else if(var2 == 11) {
         this.field3370 = 0;
      } else if(var2 == 12) {
         this.field3384 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3385 = var1.readShort();
      } else if(var2 == 14) {
         this.field3370 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3387 = var1.readUnsignedShort();
         if(this.field3387 == 65535) {
            this.field3387 = -1;
         }

         this.field3382 = var1.readUnsignedShort();
         if(this.field3382 == 65535) {
            this.field3382 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3383 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3383[var5] = var1.readUnsignedShort();
            if(this.field3383[var5] == 65535) {
               this.field3383[var5] = -1;
            }
         }

         this.field3383[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Ljq;",
      garbageValue = "426997013"
   )
   public final class267 method5016() {
      int var1 = -1;
      if(this.field3387 != -1) {
         var1 = class138.getVarbit(this.field3387);
      } else if(this.field3382 != -1) {
         var1 = class225.clientVarps[this.field3382];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3383.length - 1) {
         var2 = this.field3383[var1];
      } else {
         var2 = this.field3383[this.field3383.length - 1];
      }

      return var2 != -1?class8.method92(var2):null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "357689676"
   )
   public String method5013(int var1) {
      String var2 = this.field3365;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + MapIcon.method517(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Llc;",
      garbageValue = "-134649634"
   )
   public SpritePixels method5019() {
      if(this.field3376 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3368.get((long)this.field3376);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ChatLineBuffer.getSpriteAsSpritePixels(class177.field2314, this.field3376, 0);
            if(var1 != null) {
               field3368.put(var1, (long)this.field3376);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Llc;",
      garbageValue = "-1382838819"
   )
   public SpritePixels method5011() {
      if(this.field3377 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3368.get((long)this.field3377);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ChatLineBuffer.getSpriteAsSpritePixels(class177.field2314, this.field3377, 0);
            if(var1 != null) {
               field3368.put(var1, (long)this.field3377);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Llc;",
      garbageValue = "256269082"
   )
   public SpritePixels method5015() {
      if(this.field3378 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3368.get((long)this.field3378);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ChatLineBuffer.getSpriteAsSpritePixels(class177.field2314, this.field3378, 0);
            if(var1 != null) {
               field3368.put(var1, (long)this.field3378);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Llc;",
      garbageValue = "-748388471"
   )
   public SpritePixels method5042() {
      if(this.field3379 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3368.get((long)this.field3379);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ChatLineBuffer.getSpriteAsSpritePixels(class177.field2314, this.field3379, 0);
            if(var1 != null) {
               field3368.put(var1, (long)this.field3379);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lkr;",
      garbageValue = "586093564"
   )
   public Font method5017() {
      if(this.field3373 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3369.get((long)this.field3373);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = class177.field2314;
            IndexDataBase var4 = field3366;
            int var5 = this.field3373;
            Font var2;
            if(!class306.method5702(var3, var5, 0)) {
               var2 = null;
            } else {
               var2 = SoundTaskDataProvider.method767(var4.getConfigData(var5, 0));
            }

            if(var2 != null) {
               field3369.put(var2, (long)this.field3373);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "22"
   )
   public static void method5044() {
      field3367.reset();
      field3368.reset();
      field3369.reset();
   }
}
