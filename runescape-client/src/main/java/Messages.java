import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("Messages")
public class Messages {
   @ObfuscatedName("m")
   @Export("Messages_channels")
   static final Map Messages_channels;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   @Export("Messages_hashTable")
   static final IterableNodeHashTable Messages_hashTable;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("Messages_queue")
   static final IterableDualNodeQueue Messages_queue;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1168497831
   )
   @Export("Messages_count")
   static int Messages_count;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   @Export("soundSystem")
   static SoundSystem soundSystem;

   static {
      Messages_channels = new HashMap();
      Messages_hashTable = new IterableNodeHashTable(1024);
      Messages_queue = new IterableDualNodeQueue();
      Messages_count = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "103402661"
   )
   static void method2200() {
      if(Login.Login_username == null || Login.Login_username.length() <= 0) {
         if(ReflectionCheck.clientPreferences.rememberedUsername != null) {
            Login.Login_username = ReflectionCheck.clientPreferences.rememberedUsername;
            Client.Login_isUsernameRemembered = true;
         } else {
            Client.Login_isUsernameRemembered = false;
         }

      }
   }
}
