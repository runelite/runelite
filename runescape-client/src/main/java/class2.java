import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("o")
final class class2 implements class0 {
   @ObfuscatedName("ne")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   @Export("clanMemberManager")
   static ClanMemberManager clanMemberManager;
   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexCache13")
   static IndexData indexCache13;
   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("mapscene")
   static IndexedSprite[] mapscene;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILiu;I)Lca;",
      garbageValue = "-1268933384"
   )
   @Export("getScriptByFile")
   static Script getScriptByFile(int var0, class239 var1) {
      Script var2 = (Script)Script.field1406.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = class80.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = class80.indexScripts.takeRecordFlat(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = IndexStoreActionHandler.newScript(var5);
               if(var2 != null) {
                  Script.field1406.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "1790598729"
   )
   @Export("loadClassFromDescriptor")
   public static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1906017553"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(class89.validInterfaces[var0]) {
         return true;
      } else if(!class154.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = class154.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            class89.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = class154.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            class89.validInterfaces[var0] = true;
            return true;
         }
      }
   }
}
