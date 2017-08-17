import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class84 {
   @ObfuscatedName("x")
   static int[] field1344;
   @ObfuscatedName("g")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "Lbf;"
   )
   static class72 field1357;
   @ObfuscatedName("c")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("w")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1178999413
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lbu;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("r")
   static Calendar field1351;
   @ObfuscatedName("on")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("e")
   static final String[] field1348;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1355804057
   )
   static int field1349;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 758013495
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("f")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("p")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("nh")
   @Export("clanChatRank")
   static byte clanChatRank;

   static {
      field1344 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1351 = Calendar.getInstance();
      field1348 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1349 = 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Lhi;",
      garbageValue = "526665561"
   )
   public static Widget method1670(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class176.widgets[var1] == null || class176.widgets[var1][var2] == null) {
         boolean var3 = Ignore.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return class176.widgets[var1][var2];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1335139173"
   )
   static void method1639() {
      class93.username = class93.username.trim();
      if(class93.username.length() == 0) {
         class69.method1159("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = Script.method1871();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = class23.method184(var1, class93.username);
         }

         switch(var0) {
         case 2:
            class69.method1159("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class93.loginIndex = 6;
            break;
         case 3:
            class69.method1159("", "Error connecting to server.", "");
            break;
         case 4:
            class69.method1159("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class69.method1159("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class69.method1159("", "Error connecting to server.", "");
            break;
         case 7:
            class69.method1159("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "1953405449"
   )
   public static int method1669(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = ScriptVarType.method22(var9);
         var8 = ScriptVarType.method22(var10);
         var9 = Ignore.method1167(var9, var2);
         var10 = Ignore.method1167(var10, var2);
         if(var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var9 != var10) {
               return DecorativeObject.method2922(var9, var2) - DecorativeObject.method2922(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var11 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var11 != var12 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if(var11 != var12) {
               return DecorativeObject.method2922(var11, var2) - DecorativeObject.method2922(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if(var13 != var12) {
               return DecorativeObject.method2922(var12, var2) - DecorativeObject.method2922(var13, var2);
            }
         }

         return 0;
      }
   }
}
