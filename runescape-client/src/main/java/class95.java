import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
final class class95 implements Comparator {
   @ObfuscatedName("ij")
   static Widget field1513;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = -483759695
   )
   static int field1515;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "1065819286"
   )
   int method1775(class14 var1, class14 var2) {
      if(var2.field291 == var1.field291) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field291) {
               return -1;
            }

            if(var2.field291 == Client.world) {
               return 1;
            }
         }

         return var1.field291 < var2.field291?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method1775((class14)var1, (class14)var2);
   }

   class95(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZB)V",
      garbageValue = "-1"
   )
   static final void method1780(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      int var5;
      if(var1 && var2 != -1 && class152.validInterfaces[var2]) {
         Widget.field2646.method4127(var2);
         if(class46.widgets[var2] != null) {
            boolean var6 = true;

            for(var5 = 0; var5 < class46.widgets[var2].length; ++var5) {
               if(class46.widgets[var2][var5] != null) {
                  if(class46.widgets[var2][var5].type != 2) {
                     class46.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               class46.widgets[var2] = null;
            }

            class152.validInterfaces[var2] = false;
         }
      }

      class205.method3804(var2);
      Widget var4 = PacketBuffer.method3403(var3);
      if(var4 != null) {
         class88.method1714(var4);
      }

      class20.method142();
      if(Client.widgetRoot != -1) {
         var5 = Client.widgetRoot;
         if(class66.method1121(var5)) {
            class5.method22(class46.widgets[var5], 1);
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)LKitDefinition;",
      garbageValue = "-17"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field3360.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field3369.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method4382(new Buffer(var2));
         }

         KitDefinition.field3360.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   protected static final void method1782() {
      class46.field625.vmethod2965();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field718[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field719[var0] = 0L;
      }

      class43.field596 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IS)Z",
      garbageValue = "255"
   )
   public static boolean method1783(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4120(var1);
      if(var2 == null) {
         return false;
      } else {
         Spotanim.method4355(var2);
         return true;
      }
   }
}
