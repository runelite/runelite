import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class30 {
   @ObfuscatedName("aa")
   static RSSocket field710;
   @ObfuscatedName("j")
   static int[] field712;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1205752505
   )
   static int field713;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -458774779
   )
   int field714 = 1;
   @ObfuscatedName("o")
   LinkedHashMap field715 = new LinkedHashMap();
   @ObfuscatedName("u")
   boolean field716;
   @ObfuscatedName("af")
   static ModIcon[] field718;
   @ObfuscatedName("h")
   boolean field719;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1943098523
   )
   static int field720 = 4;

   class30(Buffer var1) {
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field720) {
            if(var1.readUnsignedByte() == 1) {
               this.field716 = true;
            }

            if(var2 > 1) {
               this.field719 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field714 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.field715.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method639(true);
         }
      } else {
         this.method639(true);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-806770170"
   )
   void method639(boolean var1) {
   }

   class30() {
      this.method639(true);
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-14932502"
   )
   static void method640() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2420(); null != var0; var0 = (WidgetNode)Client.componentTable.method2422()) {
         int var1 = var0.id;
         if(Ignore.method178(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = FaceNormal.method1932(var4);
               if(null != var5) {
                  class22.method197(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   static final void method643() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[1 + var1];
               Client.menuTargets[1 + var1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[1 + var1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[1 + var1];
               Client.menuTypes[1 + var1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
               Client.menuActionParams0[1 + var1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[1 + var1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[1 + var1];
               Client.menuIdentifiers[1 + var1] = var4;
               if(Client.field449 != -1) {
                  if(Client.field449 == var1) {
                     Client.field449 = var1 + 1;
                  } else if(1 + var1 == Client.field449) {
                     Client.field449 = var1;
                  }
               }

               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "1036067138"
   )
   public static void method644(class182 var0) {
      class186.field2783 = var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "359815462"
   )
   static String method648(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "-876591792"
   )
   static final int method649(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class84.field1469[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var1 * var4 >> 16);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LBuffer;",
      garbageValue = "-27"
   )
   Buffer method650() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field720);
      var1.putByte(this.field716?1:0);
      var1.putByte(this.field719?1:0);
      var1.putByte(this.field714);
      var1.putByte(this.field715.size());
      Iterator var2 = this.field715.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-304378835"
   )
   static final int method651(int var0, int var1) {
      int var2 = TextureProvider.method1488(var0 - 1, var1 - 1) + TextureProvider.method1488(var0 + 1, var1 - 1) + TextureProvider.method1488(var0 - 1, var1 + 1) + TextureProvider.method1488(1 + var0, 1 + var1);
      int var3 = TextureProvider.method1488(var0 - 1, var1) + TextureProvider.method1488(var0 + 1, var1) + TextureProvider.method1488(var0, var1 - 1) + TextureProvider.method1488(var0, 1 + var1);
      int var4 = TextureProvider.method1488(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2029415455"
   )
   static int method652() {
      return 9;
   }
}
