import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("BaseVarType")
public enum BaseVarType implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   @Export("INTEGER")
   INTEGER(0, 0, Integer.class, new class2()),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   @Export("LONG")
   LONG(1, 1, Long.class, new class3()),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   @Export("STRING")
   STRING(2, 2, String.class, new class5());

   @ObfuscatedName("ms")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   @Export("mouseWheel")
   static MouseWheel mouseWheel;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static IndexedSprite field33;
   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   static TextureProvider field23;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 123058171
   )
   @Export("id2")
   final int id2;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 544673551
   )
   @Export("id")
   final int id;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Lg;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.id2 = var3;
      this.id = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "19795"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;B)V",
      garbageValue = "32"
   )
   public static void method10(IndexDataBase var0) {
      class279.field3554 = var0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Ldb;",
      garbageValue = "1584972593"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(VertexNormal.field1912, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(OwnWorldComparator.field847 == 33) {
         var4 = "_rc";
      } else if(OwnWorldComparator.field847 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class167.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("kw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "-1221"
   )
   static final void method12(String var0) {
      if(LoginPacket.clanMemberManager != null) {
         PacketNode var1 = AbstractSoundSystem.method2350(ClientPacket.field2412, Client.field911.field1460);
         var1.packetBuffer.putByte(class95.getLength(var0));
         var1.packetBuffer.putString(var0);
         Client.field911.method2135(var1);
      }
   }
}
