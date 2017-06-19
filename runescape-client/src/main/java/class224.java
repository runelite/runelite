import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class224 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-2032592771"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field3497.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class91.field1409.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method4437();
         if(var1.notedTemplate != -1) {
            var1.method4442(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field3544 != -1) {
            var1.method4441(getItemDefinition(var1.field3544), getItemDefinition(var1.field3543));
         }

         if(var1.field3546 != -1) {
            var1.method4473(getItemDefinition(var1.field3546), getItemDefinition(var1.field3545));
         }

         if(!class240.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3513 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3540 = 0;
            if(var1.field3507 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3507.method3390(); var4 != null; var4 = var1.field3507.method3392()) {
                  class251 var5 = class230.method3978((int)var4.hash);
                  if(var5.field3396) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3507 = null;
               }
            }
         }

         ItemComposition.field3497.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "1085075382"
   )
   public static byte method3964(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
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

      return var1;
   }
}
