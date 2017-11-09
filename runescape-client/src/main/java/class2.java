import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
final class class2 implements class0 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Liw;",
      garbageValue = "855898976"
   )
   public static FloorUnderlayDefinition method4(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1415824244"
   )
   public static String method5(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = class272.method5013(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(IIIB)Lbp;",
      garbageValue = "50"
   )
   static final WidgetNode method3(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      PlayerComposition.method4115(var1);
      Widget var4 = PendingSpawn.method1612(var0);
      WorldMapData.method394(var4);
      if(Client.field1013 != null) {
         WorldMapData.method394(Client.field1013);
         Client.field1013 = null;
      }

      class171.method3208();
      class22.method179(class243.widgets[var0 >> 16], var4, false);
      class29.method272(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(CombatInfoListHolder.loadWidget(var5)) {
            class158.method3085(class243.widgets[var5], 1);
         }
      }

      return var3;
   }
}
