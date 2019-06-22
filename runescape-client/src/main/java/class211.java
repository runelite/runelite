import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class211 {
   @ObfuscatedName("m")
   @Export("__hg_m")
   static final String[][] __hg_m;
   @ObfuscatedName("f")
   @Export("__hg_f")
   static final String[] __hg_f;
   @ObfuscatedName("q")
   @Export("__hg_q")
   static Calendar __hg_q;
   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "Llg;"
   )
   @Export("spriteIds")
   static SpriteIds spriteIds;

   static {
      __hg_m = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      __hg_f = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      __hg_q = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2034023208"
   )
   public static int method4107(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "-1028057613"
   )
   static int method4103(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
         var4 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var9;
         if(var0 == 4101) {
            Interpreter.Interpreter_stringStackSize -= 2;
            var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
            var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + var9;
            return 1;
         } else if(var0 == 4102) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            var4 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + ByteArrayPool.method4001(var4, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var6;
            int var10;
            if(var0 == 4104) {
               var10 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               long var11 = ((long)var10 + 11745L) * 86400000L;
               Interpreter.Interpreter_calendar.setTime(new Date(var11));
               var6 = Interpreter.Interpreter_calendar.get(5);
               int var16 = Interpreter.Interpreter_calendar.get(2);
               int var8 = Interpreter.Interpreter_calendar.get(1);
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.__bv_z[var16] + "-" + var8;
               return 1;
            } else if(var0 != 4105) {
               if(var0 == 4106) {
                  var10 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Integer.toString(var10);
                  return 1;
               } else if(var0 == 4107) {
                  Interpreter.Interpreter_stringStackSize -= 2;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = WallDecoration.method3256(AttackOption.method2033(Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1], Client.language));
                  return 1;
               } else {
                  int var5;
                  byte[] var13;
                  Font var14;
                  if(var0 == 4108) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     class179.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
                     var13 = ByteArrayPool.indexCache13.takeRecord(var5, 0);
                     var14 = new Font(var13);
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var14.lineCount(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     class179.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
                     var13 = ByteArrayPool.indexCache13.takeRecord(var5, 0);
                     var14 = new Font(var13);
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var14.lineWidth(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     Interpreter.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                     if(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
                     } else {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
                     return 1;
                  } else if(var0 == 4112) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if(var0 == 4113) {
                     var10 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = ChatChannel.method2238((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4114) {
                     var10 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = VarcInt.method4807((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4115) {
                     var10 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = UrlRequest.method3271((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4116) {
                     var10 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class159.method3394((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4117) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     if(var3 != null) {
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.length();
                     } else {
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 4118) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     class179.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
                     return 1;
                  } else if(var0 == 4119) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     StringBuilder var17 = new StringBuilder(var3.length());
                     boolean var15 = false;

                     for(var6 = 0; var6 < var3.length(); ++var6) {
                        char var7 = var3.charAt(var6);
                        if(var7 == '<') {
                           var15 = true;
                        } else if(var7 == '>') {
                           var15 = false;
                        } else if(!var15) {
                           var17.append(var7);
                        }
                     }

                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var17.toString();
                     return 1;
                  } else if(var0 == 4120) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.indexOf(var4);
                     return 1;
                  } else if(var0 == 4121) {
                     Interpreter.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
                     return 1;
                  } else if(var0 == 4122) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.toUpperCase();
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               Interpreter.Interpreter_stringStackSize -= 2;
               var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
               var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
               if(Canvas.localPlayer.appearance != null && Canvas.localPlayer.appearance.isFemale) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9;
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
               }

               return 1;
            }
         }
      }
   }
}
