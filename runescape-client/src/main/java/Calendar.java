import java.util.Date;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("hg")
@Implements("Calendar")
public class Calendar {
   @ObfuscatedName("m")
   @Export("MONTH_NAMES_ENGLISH_GERMAN")
   static final String[][] MONTH_NAMES_ENGLISH_GERMAN;
   @ObfuscatedName("f")
   @Export("DAYS_OF_THE_WEEK")
   static final String[] DAYS_OF_THE_WEEK;
   @ObfuscatedName("q")
   @Export("Calendar_calendar")
   static java.util.Calendar Calendar_calendar;
   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "Llg;"
   )
   @Export("spriteIds")
   static GraphicsDefaults spriteIds;

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
      if (var0 == ScriptOpcodes.APPEND_NUM) {
         var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
         var4 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
         Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var5;
         if (var0 == ScriptOpcodes.APPEND) {
            Interpreter.Interpreter_stringStackSize -= 2;
            var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
            var5 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + var5;
            return 1;
         } else if (var0 == ScriptOpcodes.APPEND_SIGNNUM) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            var4 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + ByteArrayPool.method4001(var4, true);
            return 1;
         } else if (var0 == ScriptOpcodes.LOWERCASE) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var6;
            int var7;
            if (var0 == ScriptOpcodes.FROMDATE) {
               var7 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
               long var14 = ((long)var7 + 11745L) * 86400000L;
               Interpreter.Interpreter_calendar.setTime(new Date(var14));
               var6 = Interpreter.Interpreter_calendar.get(5);
               int var15 = Interpreter.Interpreter_calendar.get(2);
               int var16 = Interpreter.Interpreter_calendar.get(1);
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var15] + "-" + var16;
               return 1;
            } else if (var0 != ScriptOpcodes.TEXT_GENDER) {
               if (var0 == ScriptOpcodes.TOSTRING) {
                  var7 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Integer.toString(var7);
                  return 1;
               } else if (var0 == ScriptOpcodes.COMPARE) {
                  Interpreter.Interpreter_stringStackSize -= 2;
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = WallDecoration.method3256(AttackOption.method2033(Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1], Client.language));
                  return 1;
               } else {
                  int var8;
                  byte[] var9;
                  Font var10;
                  if (var0 == ScriptOpcodes.PARAHEIGHT) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     RouteStrategy.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
                     var9 = ByteArrayPool.archive13.takeFile(var8, 0);
                     var10 = new Font(var9);
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var10.lineCount(var3, var4);
                     return 1;
                  } else if (var0 == ScriptOpcodes.PARAWIDTH) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     RouteStrategy.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
                     var9 = ByteArrayPool.archive13.takeFile(var8, 0);
                     var10 = new Font(var9);
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var10.lineWidth(var3, var4);
                     return 1;
                  } else if (var0 == ScriptOpcodes.TEXT_SWITCH) {
                     Interpreter.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                     var5 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                     if (Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
                     } else {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5;
                     }

                     return 1;
                  } else if (var0 == ScriptOpcodes.ESCAPE) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
                     return 1;
                  } else if (var0 == ScriptOpcodes.APPEND_CHAR) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if (var0 == ScriptOpcodes.CHAR_ISPRINTABLE) {
                     var7 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = ChatChannel.isCharPrintable((char)var7) ? 1 : 0;
                     return 1;
                  } else if (var0 == ScriptOpcodes.CHAR_ISALPHANUMERIC) {
                     var7 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = VarcInt.isAlphaNumeric((char)var7) ? 1 : 0;
                     return 1;
                  } else if (var0 == ScriptOpcodes.CHAR_ISALPHA) {
                     var7 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = UrlRequest.isCharAlphabetic((char)var7) ? 1 : 0;
                     return 1;
                  } else if (var0 == ScriptOpcodes.CHAR_ISNUMERIC) {
                     var7 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = class159.isCharDigit((char)var7) ? 1 : 0;
                     return 1;
                  } else if (var0 == ScriptOpcodes.STRING_LENGTH) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     if (var3 != null) {
                        Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.length();
                     } else {
                        Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if (var0 == ScriptOpcodes.SUBSTRING) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     RouteStrategy.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.substring(var4, var8);
                     return 1;
                  } else if (var0 == ScriptOpcodes.REMOVETAGS) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     StringBuilder var11 = new StringBuilder(var3.length());
                     boolean var12 = false;

                     for (var6 = 0; var6 < var3.length(); ++var6) {
                        char var13 = var3.charAt(var6);
                        if (var13 == '<') {
                           var12 = true;
                        } else if (var13 == '>') {
                           var12 = false;
                        } else if (!var12) {
                           var11.append(var13);
                        }
                     }

                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.toString();
                     return 1;
                  } else if (var0 == ScriptOpcodes.STRING_INDEXOF_CHAR) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.indexOf(var4);
                     return 1;
                  } else if (var0 == ScriptOpcodes.STRING_INDEXOF_STRING) {
                     Interpreter.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                     var5 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                     var8 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.indexOf(var5, var8);
                     return 1;
                  } else if (var0 == ScriptOpcodes.UPPERCASE) {
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
               var5 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
               if (Canvas.localPlayer.appearance != null && Canvas.localPlayer.appearance.isFemale) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5;
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
               }

               return 1;
            }
         }
      }
   }

   static {
      MONTH_NAMES_ENGLISH_GERMAN = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      DAYS_OF_THE_WEEK = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      java.util.Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      Calendar_calendar = java.util.Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
