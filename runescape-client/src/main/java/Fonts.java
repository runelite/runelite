import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
@Implements("Fonts")
public class Fonts {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   IndexDataBase field3886;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   IndexDataBase field3889;
   @ObfuscatedName("i")
   @Export("map")
   HashMap map;

   @ObfuscatedSignature(
      signature = "(Ljc;Ljc;)V"
   )
   public Fonts(IndexDataBase var1, IndexDataBase var2) {
      this.field3886 = var1;
      this.field3889 = var2;
      this.map = new HashMap();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([Lkq;B)Ljava/util/HashMap;",
      garbageValue = "-80"
   )
   @Export("createMap")
   public HashMap createMap(FontName[] var1) {
      HashMap var2 = new HashMap();
      FontName[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         FontName var5 = var3[var4];
         if(this.map.containsKey(var5)) {
            var2.put(var5, this.map.get(var5));
         } else {
            Font var6 = MilliTimer.method3182(this.field3886, this.field3889, var5.field3882, "");
            if(var6 != null) {
               this.map.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1119282817"
   )
   public static String method5483(CharSequence var0) {
      return Name.method5436('*', var0.length());
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-952785331"
   )
   static void method5482() {
      if(Client.spellSelected) {
         Widget var0 = CollisionData.getWidgetChild(Resampler.field1597, Client.field1050);
         if(var0 != null && var0.field2807 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.objs = var0.field2807;
            class25.runScript(var1, 500000);
         }

         Client.spellSelected = false;
         GameEngine.method1053(var0);
      }
   }
}
