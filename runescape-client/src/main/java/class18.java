import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class18 extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1231259571
   )
   int field222;
   @ObfuscatedName("c")
   Widget field223;
   @ObfuscatedName("y")
   String field224;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1477942051
   )
   int field225;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 501334153
   )
   int field226;
   @ObfuscatedName("u")
   Widget field227;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1462542781
   )
   int field229;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1166873513
   )
   int field230;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1671809951
   )
   int field231;
   @ObfuscatedName("x")
   Object[] field232;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -932496739
   )
   public static int field234;
   @ObfuscatedName("j")
   boolean field237;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass159;II)V",
      garbageValue = "-1146944482"
   )
   static final void method209(class159 var0, int var1) {
      int var2 = var0.offset;
      class45.field919 = 0;
      XGrandExchangeOffer.method58(var0);
      class39.method819(var0);
      if(var1 != var0.offset - var2) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1968698716"
   )
   static void method210() {
      class41.username = class41.username.trim();
      if(class41.username.length() == 0) {
         class5.method67("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class8.method107();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = ScriptState.method170(var1, class41.username);
         }

         switch(var0) {
         case 2:
            class5.method67("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class41.loginIndex = 6;
            break;
         case 3:
            class5.method67("", "Error connecting to server.", "");
            break;
         case 4:
            class5.method67("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class5.method67("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class5.method67("", "Error connecting to server.", "");
            break;
         case 7:
            class5.method67("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(IIIB)LWidgetNode;",
      garbageValue = "29"
   )
   static final WidgetNode method211(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field212 = var2;
      Client.componentTable.method2403(var3, (long)var0);
      class195.method3577(var1);
      Widget var4 = World.method670(var0);
      class2.method36(var4);
      if(Client.field477 != null) {
         class2.method36(Client.field477);
         Client.field477 = null;
      }

      ScriptState.method171();
      class107.method2100(Widget.widgets[var0 >> 16], var4, false);
      class44.method889(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class44.method892(var5)) {
            CombatInfo1.method628(Widget.widgets[var5], 1);
         }
      }

      return var3;
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "-1832"
   )
   static final void method212(String var0) {
      if(null != class137.clanMembers) {
         Client.field309.method3076(214);
         Client.field309.putByte(class164.method3157(var0));
         Client.field309.method2822(var0);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-963692330"
   )
   static void method213() {
      if(class41.field868) {
         class41.field882 = null;
         class41.field847 = null;
         class205.field3095 = null;
         class41.field880 = null;
         class41.field850 = null;
         class186.field2763 = null;
         GroundObject.field1310 = null;
         class41.field851 = null;
         class41.field852 = null;
         class8.field79 = null;
         class118.field1857 = null;
         class99.field1660 = null;
         class33.field771 = null;
         Client.field595 = null;
         class8.field83 = null;
         class176.field2648 = null;
         class41.field857 = null;
         class7.field71 = null;
         class36.field807 = null;
         class41.field860 = null;
         XGrandExchangeOffer.field48 = null;
         class161.field2130 = null;
         GroundObject.method1595(2);
         class44.method884(true);
         class41.field868 = false;
      }
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-712192042"
   )
   static final boolean method214(Widget var0) {
      if(var0.field2270 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2270.length; ++var1) {
            int var2 = class39.method817(var0, var1);
            int var3 = var0.field2210[var1];
            if(var0.field2270[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2270[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2270[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-1047079639"
   )
   public static byte method215(char var0) {
      byte var1;
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 == 8364) {
            var1 = -128;
         } else if(var0 == 8218) {
            var1 = -126;
         } else if(var0 == 402) {
            var1 = -125;
         } else if(var0 == 8222) {
            var1 = -124;
         } else if(var0 == 8230) {
            var1 = -123;
         } else if(var0 == 8224) {
            var1 = -122;
         } else if(var0 == 8225) {
            var1 = -121;
         } else if(var0 == 710) {
            var1 = -120;
         } else if(var0 == 8240) {
            var1 = -119;
         } else if(var0 == 352) {
            var1 = -118;
         } else if(var0 == 8249) {
            var1 = -117;
         } else if(var0 == 338) {
            var1 = -116;
         } else if(var0 == 381) {
            var1 = -114;
         } else if(var0 == 8216) {
            var1 = -111;
         } else if(var0 == 8217) {
            var1 = -110;
         } else if(var0 == 8220) {
            var1 = -109;
         } else if(var0 == 8221) {
            var1 = -108;
         } else if(var0 == 8226) {
            var1 = -107;
         } else if(var0 == 8211) {
            var1 = -106;
         } else if(var0 == 8212) {
            var1 = -105;
         } else if(var0 == 732) {
            var1 = -104;
         } else if(var0 == 8482) {
            var1 = -103;
         } else if(var0 == 353) {
            var1 = -102;
         } else if(var0 == 8250) {
            var1 = -101;
         } else if(var0 == 339) {
            var1 = -100;
         } else if(var0 == 382) {
            var1 = -98;
         } else if(var0 == 376) {
            var1 = -97;
         } else {
            var1 = 63;
         }
      } else {
         var1 = (byte)var0;
      }

      return var1;
   }
}
