import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public final class class33 extends Renderable {
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = 251364927
   )
   static int field735;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1912212999
   )
   int field736;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -339517249
   )
   int field737;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 647697873
   )
   int field738;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -476855171
   )
   int field739;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1519182601
   )
   int field740;
   @ObfuscatedName("n")
   Sequence field741;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -976360623
   )
   int field742 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1532874881
   )
   int field743 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 349687985
   )
   int field744;
   @ObfuscatedName("r")
   boolean field747 = false;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-44"
   )
   static byte[] method756(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2090510689"
   )
   final void method757(int var1) {
      if(!this.field747) {
         this.field743 += var1;

         while(this.field743 > this.field741.frameLenghts[this.field742]) {
            this.field743 -= this.field741.frameLenghts[this.field742];
            ++this.field742;
            if(this.field742 >= this.field741.frameIDs.length) {
               this.field747 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-8"
   )
   protected final Model getModel() {
      Spotanim var1 = class160.method3154(this.field744);
      Model var2;
      if(!this.field747) {
         var2 = var1.method3539(this.field742);
      } else {
         var2 = var1.method3539(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "56"
   )
   static char method760(char var0) {
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

   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1732579613"
   )
   static void method764(Buffer var0) {
      if(null != Client.field321) {
         var0.method2850(Client.field321, 0, Client.field321.length);
      } else {
         byte[] var2 = new byte[24];

         try {
            class104.field1681.method1436(0L);
            class104.field1681.method1438(var2);

            int var3;
            for(var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
               ;
            }

            if(var3 >= 24) {
               throw new IOException();
            }
         } catch (Exception var6) {
            for(int var4 = 0; var4 < 24; ++var4) {
               var2[var4] = -1;
            }
         }

         var0.method2850(var2, 0, var2.length);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1151630226"
   )
   public static void method765(int var0) {
      class138.field1915 = 1;
      class138.field1918 = null;
      class20.field205 = -1;
      class85.field1446 = -1;
      FaceNormal.field1561 = 0;
      class105.field1713 = false;
      class138.field1917 = var0;
   }

   class33(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field744 = var1;
      this.field737 = var2;
      this.field738 = var3;
      this.field739 = var4;
      this.field740 = var5;
      this.field736 = var6 + var7;
      int var8 = class160.method3154(this.field744).field2797;
      if(var8 != -1) {
         this.field747 = false;
         this.field741 = XClanMember.getAnimation(var8);
      } else {
         this.field747 = true;
      }

   }
}
