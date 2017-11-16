import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class226 implements class225 {
   @ObfuscatedName("oy")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   public static final class226 field2852;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   public static final class226 field2853;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   public static final class226 field2854;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   public static final class226 field2859;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   public static final class226 field2856;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   public static final class226 field2857;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   public static final class226 field2858;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   public static final class226 field2855;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   static final class226 field2862;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   public static final class226 field2861;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1976354327
   )
   public final int field2860;

   static {
      field2852 = new class226("", 10);
      field2853 = new class226("", 11);
      field2854 = new class226("", 12);
      field2859 = new class226("", 13);
      field2856 = new class226("", 14);
      field2857 = new class226("", 15, new ScriptVarType[]{ScriptVarType.field66, ScriptVarType.field66}, (ScriptVarType[])null);
      field2858 = new class226("", 16, new ScriptVarType[]{ScriptVarType.field66, ScriptVarType.field66}, (ScriptVarType[])null);
      field2855 = new class226("", 17, new ScriptVarType[]{ScriptVarType.field66, ScriptVarType.field66}, (ScriptVarType[])null);
      field2862 = new class226("", 73, true, true);
      field2861 = new class226("", 76, true, false);
   }

   class226(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lu;Z[Lu;)V"
   )
   class226(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2860 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lu;[Lu;)V"
   )
   class226(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   class226(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int rsOrdinal() {
      return this.field2860;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Lin;",
      garbageValue = "-102"
   )
   public static class259 method4077(int var0) {
      class259 var1 = (class259)class259.field3442.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class259.field3445.getConfigData(34, var0);
         var1 = new class259();
         if(var2 != null) {
            var1.method4459(new Buffer(var2));
         }

         var1.method4440();
         class259.field3442.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lij;IIIZI)V",
      garbageValue = "-578214629"
   )
   public static void method4079(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class210.field2585 = 1;
      class70.field802 = var0;
      class210.field2586 = var1;
      class31.field414 = var2;
      class230.field2909 = var3;
      class230.field2905 = var4;
      FrameMap.field1952 = 10000;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lkz;I)Ljava/lang/String;",
      garbageValue = "-1692440399"
   )
   public static String method4078(CharSequence var0, class298 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class250.method4301(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2) {
            char var5 = var0.charAt(var3 - 1);
            boolean var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }

            --var3;
         }

         int var11 = var3 - var2;
         if(var11 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3919) {
               case 1:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var11 <= var6) {
               StringBuilder var10 = new StringBuilder(var11);

               for(int var12 = var2; var12 < var3; ++var12) {
                  char var7 = var0.charAt(var12);
                  if(GameEngine.method809(var7)) {
                     char var8;
                     switch(var7) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var8 = '_';
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var8 = var7;
                        break;
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
                        var8 = 'a';
                        break;
                     case 'Ç':
                     case 'ç':
                        var8 = 'c';
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var8 = 'e';
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var8 = 'i';
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var8 = 'n';
                        break;
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
                        var8 = 'o';
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var8 = 'u';
                        break;
                     case 'ß':
                        var8 = 'b';
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var8 = 'y';
                        break;
                     default:
                        var8 = Character.toLowerCase(var7);
                     }

                     if(var8 != 0) {
                        var10.append(var8);
                     }
                  }
               }

               if(var10.length() == 0) {
                  return null;
               }

               return var10.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1956344750"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
