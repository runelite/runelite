import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class254 extends CacheableNode {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   public static NodeCache field3412;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   public static NodeCache field3413;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   public static NodeCache field3414;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3430;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3432;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3433;
   @ObfuscatedName("c")
   String field3427;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2014983513
   )
   int field3431;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -181675123
   )
   int field3420;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 685042417
   )
   int field3415;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2005300625
   )
   int field3417;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -600104261
   )
   int field3423;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1293231189
   )
   int field3422;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1661052787
   )
   int field3411;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1954691845
   )
   public int field3428;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1553777277
   )
   public int field3426;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 430018005
   )
   public int field3419;
   @ObfuscatedName("l")
   public int[] field3418;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1383729319
   )
   public int field3424;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 611184249
   )
   public int field3410;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -293434253
   )
   public int field3425;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1241813815
   )
   public int field3429;

   static {
      field3413 = new NodeCache(64);
      field3414 = new NodeCache(64);
      field3412 = new NodeCache(20);
   }

   class254() {
      this.field3417 = -1;
      this.field3426 = 16777215;
      this.field3419 = 70;
      this.field3420 = -1;
      this.field3415 = -1;
      this.field3422 = -1;
      this.field3423 = -1;
      this.field3424 = 0;
      this.field3425 = 0;
      this.field3410 = -1;
      this.field3427 = "";
      this.field3428 = -1;
      this.field3429 = 0;
      this.field3431 = -1;
      this.field3411 = -1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfz;II)V",
      garbageValue = "1891880880"
   )
   void method4560(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3417 = var1.method3264();
      } else if(var2 == 2) {
         this.field3426 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3420 = var1.method3264();
      } else if(var2 == 4) {
         this.field3422 = var1.method3264();
      } else if(var2 == 5) {
         this.field3415 = var1.method3264();
      } else if(var2 == 6) {
         this.field3423 = var1.method3264();
      } else if(var2 == 7) {
         this.field3424 = var1.readShort();
      } else if(var2 == 8) {
         this.field3427 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3419 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3425 = var1.readShort();
      } else if(var2 == 11) {
         this.field3410 = 0;
      } else if(var2 == 12) {
         this.field3428 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3429 = var1.readShort();
      } else if(var2 == 14) {
         this.field3410 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3431 = var1.readUnsignedShort();
         if(this.field3431 == 65535) {
            this.field3431 = -1;
         }

         this.field3411 = var1.readUnsignedShort();
         if(this.field3411 == 65535) {
            this.field3411 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3418 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3418[var5] = var1.readUnsignedShort();
            if(this.field3418[var5] == 65535) {
               this.field3418[var5] = -1;
            }
         }

         this.field3418[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfz;S)V",
      garbageValue = "136"
   )
   void method4559(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4560(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Lic;",
      garbageValue = "-1189892538"
   )
   public final class254 method4598() {
      int var1 = -1;
      if(this.field3431 != -1) {
         var1 = class89.method1732(this.field3431);
      } else if(this.field3411 != -1) {
         var1 = class211.widgetSettings[this.field3411];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3418.length - 1) {
         var2 = this.field3418[var1];
      } else {
         var2 = this.field3418[this.field3418.length - 1];
      }

      return var2 != -1?class205.method3904(var2):null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lky;",
      garbageValue = "-695920125"
   )
   public SpritePixels method4563() {
      if(this.field3420 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3414.get((long)this.field3420);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BuildType.method4173(field3432, this.field3420, 0);
            if(var1 != null) {
               field3414.put(var1, (long)this.field3420);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lky;",
      garbageValue = "538295079"
   )
   public SpritePixels method4580() {
      if(this.field3415 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3414.get((long)this.field3415);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BuildType.method4173(field3432, this.field3415, 0);
            if(var1 != null) {
               field3414.put(var1, (long)this.field3415);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lky;",
      garbageValue = "301940821"
   )
   public SpritePixels method4565() {
      if(this.field3422 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3414.get((long)this.field3422);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BuildType.method4173(field3432, this.field3422, 0);
            if(var1 != null) {
               field3414.put(var1, (long)this.field3422);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lky;",
      garbageValue = "-566997305"
   )
   public SpritePixels method4566() {
      if(this.field3423 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3414.get((long)this.field3423);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BuildType.method4173(field3432, this.field3423, 0);
            if(var1 != null) {
               field3414.put(var1, (long)this.field3423);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Ljh;",
      garbageValue = "112"
   )
   public Font method4584() {
      if(this.field3417 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3412.get((long)this.field3417);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = field3432;
            IndexDataBase var4 = field3433;
            int var5 = this.field3417;
            Font var2;
            if(!class261.method4822(var3, var5, 0)) {
               var2 = null;
            } else {
               byte[] var7 = var4.getConfigData(var5, 0);
               Font var6;
               if(var7 == null) {
                  var6 = null;
               } else {
                  Font var8 = new Font(var7, class287.field3808, class21.offsetsY, class287.field3806, class56.field700, class114.field1675, class227.spritePixels);
                  class249.method4493();
                  var6 = var8;
               }

               var2 = var6;
            }

            if(var2 != null) {
               field3412.put(var2, (long)this.field3417);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "107"
   )
   public String method4562(int var1) {
      String var2 = this.field3427;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class223.method4148(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "-2090936165"
   )
   static boolean method4577(String var0, int var1) {
      return Parameters.method4989(var0, var1, "openjs");
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-1204820033"
   )
   static char method4597(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }
}
